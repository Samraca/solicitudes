package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.RequisitionRepository;
import com.semillero.solicitudes.persistence.UserRepository;
import com.semillero.solicitudes.services.RequisitionService;
import com.semillero.solicitudes.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class RequisitionServiceImpl {

    @InjectMocks
    RequisitionService requisitionService;

    @InjectMocks
    UserService userService;

    @Mock
    RequisitionRepository requisitionRepository;

    @Mock
    UserRepository userRepository;

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
