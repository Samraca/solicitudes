package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
}
