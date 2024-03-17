package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.services.CargoService;
import com.semillero.solicitudes.persistence.entities.CargosEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargos")
public class CargosController {
    private final CargoService cargoService;

    @Autowired
    public CargosController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<CargosEntity>> getAllCargos(){
        return ResponseEntity.ok(cargoService.getAllCargos());
    }
}
