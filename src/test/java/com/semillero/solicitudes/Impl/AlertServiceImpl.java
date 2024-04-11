package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.AlertRepository;
import com.semillero.solicitudes.services.AlertService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AlertServiceImpl {

    @InjectMocks
    AlertService alertService;

    @Mock
    AlertRepository alertRepository;

    @BeforeEach
    void setup(){
        alertService = new AlertService(alertRepository);
    }

    @Test
    void listOfAlertsIsNotNull(){
        Assertions.assertNotNull(alertService.getAllAlertas());
    }
}
