package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.JobsEntity;

import java.util.List;

public interface ICargo {
    List<JobsEntity> getAllCargos();

    JobsEntity getCargoById(Integer id);

    JobsEntity createCargo(JobsEntity cargo);

    JobsEntity updateCargo(JobsEntity cargo);

    void deleteCargo(Integer id);
}
