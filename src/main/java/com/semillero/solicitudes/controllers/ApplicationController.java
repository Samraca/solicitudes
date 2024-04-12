package com.semillero.solicitudes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ApplicationController {

    @Autowired
    public ApplicationController() {
    }

    @GetMapping(value="/health-check")
    @ResponseStatus(HttpStatus.OK)
    private String healthCheck() {
        return "OK";
    }
}
