package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.JobsRepository;
import com.semillero.solicitudes.persistence.entities.JobsEntity;
import com.semillero.solicitudes.services.interfaces.IJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobsService implements IJobs {


    private final JobsRepository jobsRepository;

    @Autowired
    public JobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    @Override
    public List<JobsEntity> getAllCargos() {
        return jobsRepository.findAll();
    }

    @Override
    public JobsEntity getCargoById(Integer id) {
        return jobsRepository.findById(id).orElse(null);
    }

    @Override
    public JobsEntity createCargo(JobsEntity cargo) {
        return jobsRepository.save(cargo);
    }

    @Override
    public JobsEntity updateCargo(JobsEntity cargo) {
        return jobsRepository.save(cargo);
    }

    @Override
    public void deleteCargo(Integer id) {
        jobsRepository.deleteById(id);
    }

}
