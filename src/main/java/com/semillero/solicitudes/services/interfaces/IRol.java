package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.RoleEntity;

import java.util.List;

public interface IRol {
    List<RoleEntity> getAllRoles();

    RoleEntity getRolById(Integer id);

    RoleEntity createRol(RoleEntity rol);

    RoleEntity updateRol(RoleEntity rol);

    void deleteRol(Integer id);
}
