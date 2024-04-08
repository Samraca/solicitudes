package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.RoleRepository;
import com.semillero.solicitudes.persistence.entities.RoleEntity;
import com.semillero.solicitudes.services.interfaces.IRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRol {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity getRolById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public RoleEntity createRol(RoleEntity rol) {
        return roleRepository.save(rol);
    }

    @Override
    public RoleEntity updateRol(RoleEntity rol) {
        return roleRepository.save(rol);
    }

    @Override
    public void deleteRol(Integer id) {
        roleRepository.deleteById(id);
    }
}
