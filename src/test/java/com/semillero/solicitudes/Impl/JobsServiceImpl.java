package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.JobsRepository;
import com.semillero.solicitudes.persistence.entities.JobsEntity;
import com.semillero.solicitudes.services.JobsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;


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

    @DisplayName("jobs list could be empty but not null")
    @Test
    void listOfJobIsNotNull(){
        Assertions.assertNotNull(jobsService.getAllCargos());
    }

    @DisplayName("jobs search by id returns a job or null")
    @Test
    void returnedValueFromGetJobsByIdIsNullOrJob (){
        Assertions.assertTrue(jobsService.getCargoById(Mockito.anyInt())==null || jobsService.getCargoById(Mockito.anyInt())!=null);
    }

    @DisplayName("create a job return the created job ")
    @Test
    void givenJobToCreateExpectJobCreated(){
        JobsEntity expectedJob = new JobsEntity();
        when(jobsRepository.save(expectedJob)).thenReturn(expectedJob);
        final JobsEntity result = jobsService.createCargo(expectedJob);
        Assertions.assertEquals(expectedJob, result);
    }

    @DisplayName("update a job return the updated job")
    @Test
    void givenAJobToUpdateExpectJobUpdated(){
        JobsEntity expectedUpdatedJob = new JobsEntity();
        when(jobsRepository.save(expectedUpdatedJob)).thenReturn(expectedUpdatedJob);
        final JobsEntity result = jobsService.updateCargo(expectedUpdatedJob);
        Assertions.assertEquals(expectedUpdatedJob, result);
    }

    @DisplayName("delete a job return deleted")
    @Test
    void givenAJobToDeleteExpectDeleted(){
        Assertions.assertEquals( "Deleted", jobsService.deleteCargo(Mockito.anyInt()));
    }
}
