package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.UsuarioEntity;

import java.util.List;

public interface IUsuario {
    List<UsuarioEntity> getAllUsuarios();

    UsuarioEntity getUsuarioById(Integer id);

    UsuarioEntity createUsuario(UsuarioEntity usuario);

    UsuarioEntity updateUsuario(UsuarioEntity usuario);

    void deleteUsuario(Integer id);
}
