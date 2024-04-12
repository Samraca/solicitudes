package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.RoleEntity;

import java.util.List;

public interface IRole {
    List<RoleEntity> getAllRoles();

    RoleEntity getRoleById(Integer id);

    RoleEntity createRole(RoleEntity rol);

    RoleEntity updateRole(RoleEntity rol);

    String deleteRole(Integer id);
}
