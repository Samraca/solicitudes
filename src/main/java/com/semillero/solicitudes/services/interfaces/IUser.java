package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.UserEntity;

import java.util.List;

public interface IUser {
    List<UserEntity> getAllUsuarios();

    UserEntity getUsuarioById(Integer id);

    UserEntity createUsuario(UserEntity usuario);

    UserEntity updateUsuario(UserEntity usuario);

    void deleteUsuario(Integer id);
}
