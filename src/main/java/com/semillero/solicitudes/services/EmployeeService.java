package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.EmployeesRepository;
import com.semillero.solicitudes.persistence.entities.EmployeeEntity;
import com.semillero.solicitudes.services.interfaces.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployee {
    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeeService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(Integer id) {
        return employeesRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity empleado) {
        return employeesRepository.save(empleado);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity empleado) {
        return employeesRepository.save(empleado);
    }

    @Override
    public String deleteEmployee(Integer id) {
        try{
            employeesRepository.deleteById(id);
            return "Deleted";
        }catch(Exception exception){
            return "Error: "+exception;
        }
    }

    public EmployeeEntity findByDocument(int documento) {
        return employeesRepository.findByDocumento(documento);
    }
}
