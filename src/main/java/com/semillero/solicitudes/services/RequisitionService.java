package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.RequisitionRepository;
import com.semillero.solicitudes.persistence.entities.EmployeeEntity;
import com.semillero.solicitudes.persistence.entities.RequisitionEntity;
import com.semillero.solicitudes.persistence.entities.UserEntity;
import com.semillero.solicitudes.services.interfaces.IRequisition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import java.time.LocalDate;
import java.time.ZoneId;


@Service
public class RequisitionService implements IRequisition {
    RequisitionRepository requisitionRepository;
    private UserService userService;

    @Autowired
    public RequisitionService(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }

    @Override
    public List<RequisitionEntity> getAllRequisitions() {
        return requisitionRepository.findAll();
    }

    @Override
    public RequisitionEntity getRequisitionById(Integer id) {
        return requisitionRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean createRequisition(RequisitionEntity solicitud) {
        RequisitionEntity solicitudCompleta = getRequisitionById(solicitud.getId());
        return checkRequisition(solicitudCompleta);
    }

    @Override
    public RequisitionEntity updateRequisition(RequisitionEntity solicitud) {
        return requisitionRepository.save(solicitud);
    }

    @Override
    public String deleteRequisition(Integer id) {
        try{
            requisitionRepository.deleteById(id);
            return "Deleted";
        }catch(Exception exception){
            return "Error: "+exception;
        }
    }

    public Optional<List<RequisitionEntity>> getRequisitionByEmployeeId(Integer empleadoId) {
        UserEntity usuario = userService.getUsersByEmployeeId(empleadoId);
        List<RequisitionEntity> solicitudes = requisitionRepository.findByUsuarioOrderByFechaCreacionDesc(usuario);
        return Optional.ofNullable(solicitudes.isEmpty() ? null : solicitudes);
    }

    public boolean checkRequisition(RequisitionEntity solicitud) {
        UserEntity usuario = userService.getUsersById(solicitud.getId());
        EmployeeEntity empleado = usuario.getEmpleado();
        String tipoContrato = empleado.getTipoContrato();

        Date fechaIngreso = empleado.getFechaIngreso();
        LocalDate fechaIngresoLocalDate = fechaIngreso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int diasTrabajados = calculateBusinessDay(fechaIngresoLocalDate, LocalDate.now());
        double anosTrabajados = (double) diasTrabajados / 365;
        int diasVacaciones = (int) Math.round(anosTrabajados * 15);
        int diasAnticipacion = calculateBusinessDay(LocalDate.now(), solicitud.getFechaInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        boolean isDateValid = solicitud.getFechaInicio().after(solicitud.getFechaCreacion()) && solicitud.getFechaInicio().before(solicitud.getFechaFin());
        return !tipoContrato.equals("prestacion de servicios")
        && solicitud.getDiasSolicitados() <= diasVacaciones
        && diasAnticipacion >= 15 && diasTrabajados >= 60 && isDateValid;
    }

    public int calculateBusinessDay(LocalDate fechaInicio, LocalDate fechaFin) {
        int diasHabiles = 0;
        while (fechaInicio.isBefore(fechaFin) || fechaInicio.isEqual(fechaFin)) {
            switch (fechaInicio.getDayOfWeek()) {
                case SATURDAY:
                case SUNDAY:
                    break;
                default:
                    diasHabiles++;
            }
            fechaInicio = fechaInicio.plusDays(1);
        }
        return diasHabiles;
    }
}
