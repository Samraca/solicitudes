package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;

import java.util.List;

public interface IEmpleado {
    List<EmpleadoEntity> getAllEmpleados();
    EmpleadoEntity getEmpleadoById(Integer id);
    EmpleadoEntity createEmpleado(EmpleadoEntity empleado);
    EmpleadoEntity updateEmpleado(EmpleadoEntity empleado);
    void deleteEmpleado(Integer id);
}
