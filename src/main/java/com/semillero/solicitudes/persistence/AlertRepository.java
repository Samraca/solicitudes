package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<AlertEntity, Integer>{
}
