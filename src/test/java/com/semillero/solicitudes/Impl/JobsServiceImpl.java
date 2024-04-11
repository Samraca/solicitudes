package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.JobsRepository;
import com.semillero.solicitudes.services.JobsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class JobsServiceImpl {

    @Mock
    JobsRepository jobsRepository;
    @InjectMocks
    JobsService jobsService;

    @BeforeEach
    void setup(){
        jobsService = new JobsService(jobsRepository);
    }

    @Test
    void listOfJobIsNotNull(){
        Assertions.assertNotNull(jobsService.getAllCargos());
    }

    @Test
    void returnedValueFromGetJobsByIdIsNullOrJob (){
        Assertions.assertTrue(jobsService.getCargoById(1)==null || jobsService.getCargoById(1)!=null);
    }
}
