package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.AlertaEntity;
import com.semillero.solicitudes.services.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    @Autowired
    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<AlertaEntity>> getAllAlertas(){
        return ResponseEntity.ok(alertaService.getAllAlertas());
    }
}
