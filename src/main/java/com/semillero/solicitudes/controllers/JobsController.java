package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.services.JobsService;
import com.semillero.solicitudes.persistence.entities.JobsEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cargos")
public class JobsController {
    private final JobsService jobsService;

    @Autowired
    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<JobsEntity>> getAllCargos(){
        return ResponseEntity.ok(jobsService.getAllCargos());
    }
}
