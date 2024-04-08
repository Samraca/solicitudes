package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.EmployeesRepository;
import com.semillero.solicitudes.persistence.entities.EmployeeEntity;
import com.semillero.solicitudes.services.interfaces.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmpleado {
    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeeService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public List<EmployeeEntity> getAllEmpleados() {
        return employeesRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmpleadoById(Integer id) {
        return employeesRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeeEntity createEmpleado(EmployeeEntity empleado) {
        return employeesRepository.save(empleado);
    }

    @Override
    public EmployeeEntity updateEmpleado(EmployeeEntity empleado) {
        return employeesRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        employeesRepository.deleteById(id);
    }

    public EmployeeEntity findByDocumento(int documento) {
        return employeesRepository.findByDocumento(documento);
    }
}
