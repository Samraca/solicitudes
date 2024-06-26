package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.dto.LoginRequest;
import com.semillero.solicitudes.persistence.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.semillero.solicitudes.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<UserEntity>> getAllUsuarios(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
