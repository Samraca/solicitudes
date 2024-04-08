package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.JobsRepository;
import com.semillero.solicitudes.persistence.entities.JobsEntity;
import com.semillero.solicitudes.services.interfaces.ICargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsService implements ICargo {

    private final JobsRepository cargoRepository;

    @Autowired
    public JobsService(JobsRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<JobsEntity> getAllCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public JobsEntity getCargoById(Integer id) {
        return cargoRepository.findById(id).orElse(null);
    }

    @Override
    public JobsEntity createCargo(JobsEntity cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public JobsEntity updateCargo(JobsEntity cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public void deleteCargo(Integer id) {
        cargoRepository.deleteById(id);
    }

}
