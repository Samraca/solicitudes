package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Integer>{
    EmployeeEntity findByDocumento(int documento);
    Optional<EmployeeEntity> findById(Integer id);
}
