package com.semillero.solicitudes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    public ApplicationController() {
    }

    @GetMapping(value="/health-check")
    private String healthCheck() {
        return "OK";
    }
}
