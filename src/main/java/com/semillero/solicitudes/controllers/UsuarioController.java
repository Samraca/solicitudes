package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.dto.LoginRequest;
import com.semillero.solicitudes.persistence.UsuarioRepository;
import com.semillero.solicitudes.persistence.entities.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.semillero.solicitudes.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<UsuarioEntity>> getAllUsuarios(){
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        UsuarioEntity usuario = usuarioService.findByUsername(loginRequest.getUsername());
        if (usuario != null && usuario.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Usuario autenticado correctamente");
        } else {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }
}
