package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import com.semillero.solicitudes.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadosController (EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<EmpleadoEntity>> getAllEmpleados(){
        return ResponseEntity.ok(empleadoService.getAllEmpleados());
    }
}
