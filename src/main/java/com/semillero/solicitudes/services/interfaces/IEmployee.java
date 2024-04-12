package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.EmployeeEntity;

import java.util.List;

public interface IEmployee {
    List<EmployeeEntity> getAllEmpleados();
    EmployeeEntity getEmpleadoById(Integer id);
    EmployeeEntity createEmpleado(EmployeeEntity empleado);
    EmployeeEntity updateEmpleado(EmployeeEntity empleado);
    String deleteEmpleado(Integer id);
}
