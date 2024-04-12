package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.UserEntity;

import java.util.List;

public interface IUser {
    List<UserEntity> getAllUsers();

    UserEntity getUsersById(Integer id);

    UserEntity createUser(UserEntity usuario);

    UserEntity updateUser(UserEntity usuario);

    String deleteUser(Integer id);
}
