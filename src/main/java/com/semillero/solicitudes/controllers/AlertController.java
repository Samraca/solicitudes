package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.AlertEntity;
import com.semillero.solicitudes.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/alertas")
public class AlertController {

    private final AlertService alertService;

    @Autowired
    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<AlertEntity>> getAllAlertas(){
        return ResponseEntity.ok(alertService.getAllAlertas());
    }
}
