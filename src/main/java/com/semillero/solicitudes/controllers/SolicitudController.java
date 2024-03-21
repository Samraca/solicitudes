package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.SolicitudEntity;
import com.semillero.solicitudes.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    @Autowired
    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<SolicitudEntity>> getAllSolicitudes(){
        return ResponseEntity.ok(solicitudService.getAllSolicitudes());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createSolicitud(@RequestBody SolicitudEntity solicitud){
        if (solicitudService.aprobarSolicitud(solicitud)) {
            return new ResponseEntity<>("La solicitud ha sido aprobada", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("La solicitud no cumple con las reglas", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/getByEmpleadoId")
    public ResponseEntity<List<SolicitudEntity>> getSolicitudesByEmpleadoId(@RequestParam Integer empleadoId){
        Optional<List<SolicitudEntity>> solicitudes = solicitudService.getSolicitudesByEmpleadoId(empleadoId);
        return solicitudes.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
