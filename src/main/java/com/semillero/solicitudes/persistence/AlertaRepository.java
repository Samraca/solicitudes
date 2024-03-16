package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.AlertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<AlertaEntity, Integer>{
}
