package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import com.semillero.solicitudes.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
    UsuarioEntity findByUsername(String username);

    UsuarioEntity findByEmpleadoId(EmpleadoEntity empleado);
}
