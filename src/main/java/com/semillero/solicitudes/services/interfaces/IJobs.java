package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.JobsEntity;

import java.util.List;

public interface IJobs {
    List<JobsEntity> getAllJobs();

    JobsEntity getJobById(Integer id);

    JobsEntity createJob(JobsEntity cargo);

    JobsEntity updateJob(JobsEntity cargo);

    String deleteJob(Integer id);
}
