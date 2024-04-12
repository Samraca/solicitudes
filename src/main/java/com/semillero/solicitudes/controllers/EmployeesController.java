package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.dto.JobsDTO;
import com.semillero.solicitudes.dto.EmployeesDTO;
import com.semillero.solicitudes.persistence.entities.EmployeeEntity;
import com.semillero.solicitudes.services.JobsService;
import com.semillero.solicitudes.services.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/empleados")
public class EmployeesController {

    private final EmployeeService employeeService;
    private final JobsService jobsService;

    @Autowired
    public EmployeesController(EmployeeService employeeService, JobsService jobsService) {
        this.employeeService = employeeService;
        this.jobsService = jobsService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<EmployeeEntity>> getAllEmpleados(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @RequestMapping("/getById")
    public ResponseEntity<?> getEmpleadoById(@RequestParam Integer id){
        EmployeeEntity empleado = employeeService.getEmployeeById(id);
        if (empleado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado con id: " + id);
        }
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("/create")
    public EmployeeEntity createEmpleado(@RequestBody EmployeesDTO empleadoDTO){
        EmployeeEntity empleado = convertEmpleadosDtoToEmpleadosEntity(empleadoDTO);
        EmployeeEntity existingEmpleado = employeeService.findByDocument(empleadoDTO.getDocumento());
        if (existingEmpleado != null) {
            throw new IllegalArgumentException("Ya existe un empleado con el documento: " + empleado.getDocumento());
        }
        return employeeService.createEmployee(empleado);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeEntity> updateEmpleado(@RequestBody EmployeesDTO empleadoDTO){
        EmployeeEntity empleado = convertEmpleadosDtoToEmpleadosEntity(empleadoDTO);
        EmployeeEntity existingEmpleado = employeeService.getEmployeeById(empleado.getId());
        if (existingEmpleado == null) {
            throw new EntityNotFoundException("Empleado no encontrado con id: " + empleado.getId());
        }
        return ResponseEntity.ok(employeeService.updateEmployee(empleado));
    }

    @RequestMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmpleado(@RequestParam Integer id){
        EmployeeEntity existingEmpleado = employeeService.getEmployeeById(id);
        if (existingEmpleado == null) {
            throw new EntityNotFoundException("Empleado no encontrado con id: " + id);
        }
        employeeService.deleteEmployee(id);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    public EmployeeEntity convertEmpleadosDtoToEmpleadosEntity(EmployeesDTO empleadoDto) {
    EmployeeEntity empleado = new EmployeeEntity();
    empleado.setId(empleadoDto.getId());
    empleado.setDocumento(empleadoDto.getDocumento());
    empleado.setTipoDocumento(empleadoDto.getTipoDocumento());
    empleado.setNombre(empleadoDto.getNombre());
    empleado.setApellido(empleadoDto.getApellido());
    empleado.setTelefono(empleadoDto.getTelefono());
    empleado.setDireccion(empleadoDto.getDireccion());
    empleado.setFechaIngreso(empleadoDto.getFechaIngreso());
    empleado.setFechaRetiro(empleadoDto.getFechaRetiro());
    empleado.setTipoContrato(empleadoDto.getTipoContrato());
    empleado.setEstado(empleadoDto.getEstado());
    empleado.setSupervisor(employeeService.getEmployeeById(empleadoDto.getSupervisor()));
    JobsDTO cargo = empleadoDto.getCargo();
    empleado.setCargo(jobsService.getJobById(cargo.getId()));
    return empleado;
}
}
