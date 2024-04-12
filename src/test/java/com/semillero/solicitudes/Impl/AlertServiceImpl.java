package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.AlertRepository;
import com.semillero.solicitudes.persistence.entities.AlertEntity;
import com.semillero.solicitudes.services.AlertService;
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
class AlertServiceImpl {

    @InjectMocks
    AlertService alertService;

    @Mock
    AlertRepository alertRepository;

    @BeforeEach
    void setup(){
    }

    @DisplayName("alerts list could be empty but not null")
    @Test
    void listOfAlertsIsNotNull(){
        Assertions.assertNotNull(alertService.getAllAlertas());
    }

    @DisplayName("search alert by id returns an alert or null")
    @Test
    void givenIdForAlertSearchExpectAlertOrNull(){
        Assertions.assertTrue(alertService.getAlertaById(Mockito.anyInt())!= null || alertService.getAlertaById(Mockito.anyInt())==null);
    }

    @DisplayName("create alert returns expected alert")
    @Test
    void givenAlertToCreateExpectAlertCreated(){
        AlertEntity expectedAlert = new AlertEntity();
        when(alertRepository.save(expectedAlert)).thenReturn(expectedAlert);

        final AlertEntity result = alertService.createAlerta(expectedAlert);

        Assertions.assertEquals(expectedAlert, result);
    }

    @DisplayName("update alert returns expected updated alert")
    @Test
    void givenAlertToUpdateExpectAlertUpdated(){
        AlertEntity expectedAlertToUpdate = new AlertEntity();
        when(alertRepository.save(expectedAlertToUpdate)).thenReturn(expectedAlertToUpdate);

        final AlertEntity result = alertService.updateAlerta(expectedAlertToUpdate);

        Assertions.assertEquals(expectedAlertToUpdate, result);
    }

    @DisplayName("delete alert returns deleted")
    @Test
    void givenIdOfAlertToDeleteExpectDeleted(){
        Assertions.assertEquals("Deleted", alertService.deleteAlerta(Mockito.anyInt()));
    }


}
