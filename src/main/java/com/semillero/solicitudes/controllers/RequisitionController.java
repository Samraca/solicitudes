package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.dto.RequisitionDTO;
import com.semillero.solicitudes.persistence.entities.RequisitionEntity;
import com.semillero.solicitudes.persistence.entities.UserEntity;
import com.semillero.solicitudes.services.RequisitionService;
import com.semillero.solicitudes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/solicitudes")
public class RequisitionController {

    private final RequisitionService requisitionService;
    private UserService userService;

    @Autowired
    public RequisitionController(RequisitionService requisitionService) {
        this.requisitionService = requisitionService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<RequisitionEntity>> getAllSolicitudes(){
        return ResponseEntity.ok(requisitionService.getAllRequisitions());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createSolicitud(@RequestBody RequisitionDTO requisitionDto){
        RequisitionEntity solicitud = convertSolicitudDtoToSolicitudEntity(requisitionDto);
        if (requisitionService.checkRequisition(solicitud)) {
            return new ResponseEntity<>("La solicitud ha sido aprobada", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("La solicitud no cumple con las reglas", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/getByEmpleadoId")
    public ResponseEntity<List<RequisitionEntity>> getSolicitudesByEmpleadoId(@RequestParam Integer empleadoId){
        Optional<List<RequisitionEntity>> solicitudes = requisitionService.getRequisitionByEmployeeId(empleadoId);
        return solicitudes.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public RequisitionEntity convertSolicitudDtoToSolicitudEntity(RequisitionDTO requisitionDto) {
    RequisitionEntity solicitud = new RequisitionEntity();
    solicitud.setId(requisitionDto.getIdEmpleado());
    solicitud.setFechaInicio(requisitionDto.getFechaInicio());
    solicitud.setFechaFin(requisitionDto.getFechaFin());
    solicitud.setDiasSolicitados(requisitionDto.getDiasSolicitados());
    solicitud.setObservaciones(requisitionDto.getObservaciones());
    solicitud.setEstado(requisitionDto.getEstado());
    solicitud.setFechaCreacion(requisitionDto.getFechaCreacion());
    solicitud.setFechaRetorno(requisitionDto.getFechaRetorno());
    // ... establecer otros campos ...

    // Buscar el UserEntity correspondiente al ID del empleado
    UserEntity usuario = userService.getUsersByEmployeeId(requisitionDto.getIdEmpleado());
    solicitud.setUsuario(usuario);

    return solicitud;
}
}
