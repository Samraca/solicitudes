package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.RequisitionEntity;
import com.semillero.solicitudes.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequisitionRepository extends JpaRepository<RequisitionEntity, Integer> {
    List<RequisitionEntity> findByUsuarioOrderByFechaCreacionDesc(UserEntity usuario);
}
