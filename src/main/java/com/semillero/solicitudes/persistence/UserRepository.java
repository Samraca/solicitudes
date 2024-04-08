package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.EmployeeEntity;
import com.semillero.solicitudes.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    UserEntity findByUsername(String username);

    UserEntity findByEmpleadoId(EmployeeEntity empleado);
}
