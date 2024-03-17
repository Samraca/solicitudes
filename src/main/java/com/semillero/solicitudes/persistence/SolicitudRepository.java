package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.SolicitudEntity;
import com.semillero.solicitudes.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<SolicitudEntity, Integer> {
    List<SolicitudEntity> findByUsuarioOrderByFechaCreacionDesc(UsuarioEntity usuario);
}
