package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadosRepository extends JpaRepository<EmpleadoEntity, Integer>{
    EmpleadoEntity findByDocumento(int documento);
    Optional<EmpleadoEntity> findById(Integer id);
}
