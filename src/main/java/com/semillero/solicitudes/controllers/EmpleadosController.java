package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.EmpleadosRepository;
import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import com.semillero.solicitudes.services.EmpleadoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/getById")
    public ResponseEntity<?> getEmpleadoById(@RequestParam Integer id){
        EmpleadoEntity empleado = empleadoService.getEmpleadoById(id);
        if (empleado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado con id: " + id);
        }
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("/create")
    public EmpleadoEntity createEmpleado(@RequestBody EmpleadoEntity empleado){
        EmpleadoEntity existingEmpleado = empleadoService.findByDocumento(empleado.getDocumento());
        if (existingEmpleado != null) {
            throw new IllegalArgumentException("Ya existe un empleado con el documento: " + empleado.getDocumento());
        }
        return empleadoService.createEmpleado(empleado);
    }

    @PutMapping("/update")
    public ResponseEntity<EmpleadoEntity> updateEmpleado(@RequestBody EmpleadoEntity empleado){
        EmpleadoEntity existingEmpleado = empleadoService.getEmpleadoById(empleado.getId());
        if (existingEmpleado == null) {
            throw new EntityNotFoundException("Empleado no encontrado con id: " + empleado.getId());
        }
        return ResponseEntity.ok(empleadoService.updateEmpleado(empleado));
    }

    @RequestMapping("/delete")
    public void deleteEmpleado(@RequestParam Integer id){
        EmpleadoEntity existingEmpleado = empleadoService.getEmpleadoById(id);
        if (existingEmpleado == null) {
            throw new EntityNotFoundException("Empleado no encontrado con id: " + id);
        }
        empleadoService.deleteEmpleado(id);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
