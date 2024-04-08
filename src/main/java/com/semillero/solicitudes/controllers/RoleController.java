package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.RoleEntity;
import com.semillero.solicitudes.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rol")
public class RoleController {

    private final RoleService roleService;
    
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<RoleEntity>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }
}
