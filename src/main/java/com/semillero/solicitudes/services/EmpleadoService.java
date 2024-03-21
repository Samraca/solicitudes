package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.EmpleadosRepository;
import com.semillero.solicitudes.persistence.entities.CargosEntity;
import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import com.semillero.solicitudes.services.interfaces.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleado {
    private final EmpleadosRepository empleadosRepository;

    @Autowired
    public EmpleadoService(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

    @Override
    public List<EmpleadoEntity> getAllEmpleados() {
        return empleadosRepository.findAll();
    }

    @Override
    public EmpleadoEntity getEmpleadoById(Integer id) {
        return empleadosRepository.findById(id).orElse(null);
    }

    @Override
    public EmpleadoEntity createEmpleado(EmpleadoEntity empleado) {
        return empleadosRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleado) {
        return empleadosRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadosRepository.deleteById(id);
    }

    public EmpleadoEntity findByDocumento(int documento) {
        return empleadosRepository.findByDocumento(documento);
    }
}
