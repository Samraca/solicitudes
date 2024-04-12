package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.EmployeeEntity;

import java.util.List;

public interface IEmployee {
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity getEmployeeById(Integer id);
    EmployeeEntity createEmployee(EmployeeEntity empleado);
    EmployeeEntity updateEmployee(EmployeeEntity empleado);
    String deleteEmployee(Integer id);
}
