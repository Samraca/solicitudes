package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.RoleRepository;
import com.semillero.solicitudes.persistence.entities.RoleEntity;
import com.semillero.solicitudes.services.interfaces.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRole {

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
    public RoleEntity getRoleById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public RoleEntity createRole(RoleEntity rol) {
        return roleRepository.save(rol);
    }

    @Override
    public RoleEntity updateRole(RoleEntity rol) {
        return roleRepository.save(rol);
    }

    @Override
    public String deleteRole(Integer id) {
        try{
            roleRepository.deleteById(id);
            return "Deleted";
        }catch(Exception exception){
            return "Error: "+exception;
        }
    }
}
