package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.CargosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargosRepository extends JpaRepository<CargosEntity, Integer> {
}
