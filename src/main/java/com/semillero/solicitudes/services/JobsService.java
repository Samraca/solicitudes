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
    public List<JobsEntity> getAllJobs() {
        return jobsRepository.findAll();
    }

    @Override
    public JobsEntity getJobById(Integer id) {
        return jobsRepository.findById(id).orElse(null);
    }

    @Override
    public JobsEntity createJob(JobsEntity cargo) {
        return jobsRepository.save(cargo);
    }

    @Override
    public JobsEntity updateJob(JobsEntity cargo) {
        return jobsRepository.save(cargo);
    }

    @Override
    public String deleteJob(Integer id) {
        try {
            jobsRepository.deleteById(id);
            return "Deleted";
        } catch (Exception exception){
            return ""+exception;
        }
    }
}
