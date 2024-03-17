package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.UsuarioRepository;
import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import com.semillero.solicitudes.persistence.EmpleadosRepository;
import com.semillero.solicitudes.persistence.entities.UsuarioEntity;
import com.semillero.solicitudes.services.interfaces.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuario {
    private final UsuarioRepository usuarioRepository;
    private final EmpleadosRepository empleadosRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, EmpleadosRepository empleadosRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empleadosRepository = empleadosRepository;
    }

    @Override
    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public UsuarioEntity getUsuarioByEmpleadoId(Integer empleadoId) {
        EmpleadoEntity empleado = empleadosRepository.findById(empleadoId).orElse(null);
        return usuarioRepository.findByEmpleadoId(empleado);
    }

    @Override
    public UsuarioEntity createUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity updateUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioEntity findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
