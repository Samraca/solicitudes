package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.RoleEntity;

import java.util.List;

public interface IRole {
    List<RoleEntity> getAllRoles();

    RoleEntity getRolById(Integer id);

    RoleEntity createRol(RoleEntity rol);

    RoleEntity updateRol(RoleEntity rol);

    String deleteRol(Integer id);
}
