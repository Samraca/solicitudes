package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.EmployeeEntity;

import java.util.List;

public interface IEmpleado {
    List<EmployeeEntity> getAllEmpleados();
    EmployeeEntity getEmpleadoById(Integer id);
    EmployeeEntity createEmpleado(EmployeeEntity empleado);
    EmployeeEntity updateEmpleado(EmployeeEntity empleado);
    void deleteEmpleado(Integer id);
}
