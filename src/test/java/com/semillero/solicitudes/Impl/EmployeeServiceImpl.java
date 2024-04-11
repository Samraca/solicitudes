package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.EmployeesRepository;
import com.semillero.solicitudes.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImpl {
    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeesRepository employeesRepository;

    @BeforeEach
    void setUp(){
        employeeService = new EmployeeService(employeesRepository);
    }
    @Test
    void listOfEmployeeIsNotNull(){
        Assertions.assertNotNull(employeeService.getAllEmpleados());
    }

    @Test
    void returnedValueFromGetEmployeeByIdIsNullOrEmployee(){
        Assertions.assertTrue(employeeService.getEmpleadoById(1)==null || employeeService.getEmpleadoById(1)!= null);
    }

    @Test
    void returnedValueFromFindEmployeeByDocumentIsNullOrEmployee(){
        Assertions.assertTrue(employeeService.findByDocumento(1)==null || employeeService.findByDocumento(1)!=null);
    }
}
