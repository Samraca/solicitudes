package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.SolicitudRepository;
import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import com.semillero.solicitudes.persistence.entities.SolicitudEntity;
import com.semillero.solicitudes.persistence.entities.UsuarioEntity;
import com.semillero.solicitudes.services.interfaces.ISolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import java.time.LocalDate;
import java.time.ZoneId;


@Service
public class SolicitudService implements ISolicitud {
    SolicitudRepository solicitudRepository;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public List<SolicitudEntity> getAllSolicitudes() {
        return solicitudRepository.findAll();
    }

    @Override
    public SolicitudEntity getSolicitudById(Integer id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean createSolicitud(SolicitudEntity solicitud) {
        SolicitudEntity solicitudCompleta = getSolicitudById(solicitud.getId());
        return aprobarSolicitud(solicitudCompleta);
    }

    @Override
    public SolicitudEntity updateSolicitud(SolicitudEntity solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public void deleteSolicitud(Integer id) {
        solicitudRepository.deleteById(id);
    }

    public Optional<List<SolicitudEntity>> getSolicitudesByEmpleadoId(Integer empleadoId) {
        UsuarioEntity usuario = usuarioService.getUsuarioByEmpleadoId(empleadoId);
        List<SolicitudEntity> solicitudes = solicitudRepository.findByUsuarioOrderByFechaCreacionDesc(usuario);
        return Optional.ofNullable(solicitudes.isEmpty() ? null : solicitudes);
    }

    public boolean aprobarSolicitud(SolicitudEntity solicitud) {
        UsuarioEntity usuario = usuarioService.getUsuarioById(solicitud.getId());
        EmpleadoEntity empleado = usuario.getEmpleado();
        String tipoContrato = empleado.getTipoContrato();

        Date fechaIngreso = empleado.getFechaIngreso();
        LocalDate fechaIngresoLocalDate = fechaIngreso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int diasTrabajados = calcularDiasHabiles(fechaIngresoLocalDate, LocalDate.now());
        double anosTrabajados = (double) diasTrabajados / 365;
        int diasVacaciones = (int) Math.round(anosTrabajados * 15);
        int diasAnticipacion = calcularDiasHabiles(LocalDate.now(), solicitud.getFechaInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        boolean isDateValid = solicitud.getFechaInicio().after(solicitud.getFechaCreacion()) && solicitud.getFechaInicio().before(solicitud.getFechaFin());
        return !tipoContrato.equals("prestacion de servicios")
        && solicitud.getDiasSolicitados() <= diasVacaciones
        && diasAnticipacion >= 15 && diasTrabajados >= 60 && isDateValid;
    }

    public int calcularDiasHabiles(LocalDate fechaInicio, LocalDate fechaFin) {
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
