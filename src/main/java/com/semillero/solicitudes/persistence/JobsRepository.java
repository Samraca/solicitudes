package com.semillero.solicitudes.persistence;

import com.semillero.solicitudes.persistence.entities.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<JobsEntity, Integer> {
}
