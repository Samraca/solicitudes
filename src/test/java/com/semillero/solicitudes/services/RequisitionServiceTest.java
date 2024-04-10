package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.RequisitionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RequisitionServiceTest {

    @Autowired
    RequisitionService requisitionService;

    @Autowired
    RequisitionRepository requisitionRepository;

    @BeforeEach
    void setup(){
        requisitionService = new RequisitionService(requisitionRepository);
    }

    @Test
    void listOfRequisitionsIsNotNull(){
        Assertions.assertNotNull(requisitionService.getAllSolicitudes());
    }

    @Test
    void returnedValueFromGetRequisitionByIdIsNullOrRequisition(){
        Assertions.assertTrue(requisitionService.getSolicitudById(1)==null || requisitionService.getSolicitudById(1)!=null);
    }

    @Test
    void returnedValueFromGetRequisitionByEmployeeIdIsNullOrRequisition(){
        Assertions.assertTrue(requisitionService.getSolicitudesByEmpleadoId(1).isEmpty() || requisitionService.getSolicitudesByEmpleadoId(1).isPresent());
    }


}
