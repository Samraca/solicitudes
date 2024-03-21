package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.RolEntity;
import com.semillero.solicitudes.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rol")
public class RolController {

    private final RolService rolService;
    
    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<RolEntity>> getAllRoles(){
        return ResponseEntity.ok(rolService.getAllRoles());
    }
}
