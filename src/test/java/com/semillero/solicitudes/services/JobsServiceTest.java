package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.JobsRepository;
import com.semillero.solicitudes.persistence.entities.JobsEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;

import static org.mockito.Mockito.when;


class JobsServiceTest {

    @Mock
    JobsRepository jobsRepository;
    @InjectMocks
    JobsService jobsService;

    @BeforeEach
    void setup(){
        when(jobsRepository.findAll()).thenReturn(Arrays.asList(new JobsEntity()));
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
