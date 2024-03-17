package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.RolEntity;

import java.util.List;

public interface IRol {
    List<RolEntity> getAllRoles();

    RolEntity getRolById(Integer id);

    RolEntity createRol(RolEntity rol);

    RolEntity updateRol(RolEntity rol);

    void deleteRol(Integer id);
}
