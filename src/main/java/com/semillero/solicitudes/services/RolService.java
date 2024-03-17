package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.RolRepository;
import com.semillero.solicitudes.persistence.entities.RolEntity;
import com.semillero.solicitudes.services.interfaces.IRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRol {

    private final RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<RolEntity> getAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public RolEntity getRolById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public RolEntity createRol(RolEntity rol) {
        return rolRepository.save(rol);
    }

    @Override
    public RolEntity updateRol(RolEntity rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void deleteRol(Integer id) {
        rolRepository.deleteById(id);
    }
}
