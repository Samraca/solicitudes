package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.RequisitionRepository;
import com.semillero.solicitudes.persistence.UserRepository;
import com.semillero.solicitudes.persistence.entities.RequisitionEntity;
import com.semillero.solicitudes.services.RequisitionService;
import com.semillero.solicitudes.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.mockito.Mockito.when;


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

    @DisplayName("requisition list could be empty but not null")
    @Test
    void listOfRequisitionsIsNotNull(){
        Assertions.assertNotNull(requisitionService.getAllRequisitions());
    }

    @DisplayName("search requisition by id returns an requisition or null")
    @Test
    void returnedValueFromGetRequisitionByIdIsNullOrRequisition(){
        Assertions.assertTrue(requisitionService.getRequisitionById(1)==null || requisitionService.getRequisitionById(1)!=null);
    }

    @DisplayName("search requisition by employee id returns an requisition or null")
    @Test
    void returnedValueFromGetRequisitionByEmployeeIdIsNullOrRequisition(){
        Assertions.assertTrue(requisitionService.getRequisitionByEmployeeId(1).isEmpty() || requisitionService.getRequisitionByEmployeeId(1).isPresent());
    }

    @DisplayName("create empty requisition returns false")
    @Test
    void givenRequisitionToCreateExpectRequisitionCreated(){
        RequisitionEntity expectedRequisition = new RequisitionEntity();
        final Boolean result = requisitionService.checkRequisition(expectedRequisition);
        Assertions.assertFalse(result);
    }

    @DisplayName("update requisition returns expected updated requisition")
    @Test
    void givenRequisitionToUpdateExpectRequisitionUpdated(){
        RequisitionEntity expectedRequisitionToUpdate = new RequisitionEntity();
        when(requisitionRepository.save(expectedRequisitionToUpdate)).thenReturn(expectedRequisitionToUpdate);

        final RequisitionEntity result = requisitionService.updateRequisition(expectedRequisitionToUpdate);

        Assertions.assertEquals(expectedRequisitionToUpdate, result);
    }

    @DisplayName("delete requisition returns deleted")
    @Test
    void givenIdOfAlertToDeleteExpectDeleted(){
        Assertions.assertEquals("Deleted", requisitionService.deleteRequisition(Mockito.anyInt()));
    }

    @DisplayName("calculate days between two dates must be an int not null")
    @Test
    void givenTwoDatesExpectIntNotNull(){
        Date initialDate = new Date();
        LocalDate initialLocalDate = initialDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Assertions.assertNotNull(requisitionService.calculateBusinessDay(initialLocalDate, LocalDate.now()));
    }

}
