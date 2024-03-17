package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.SolicitudEntity;
import com.semillero.solicitudes.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
