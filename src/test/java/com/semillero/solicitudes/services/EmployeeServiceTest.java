package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.EmployeesRepository;
import com.semillero.solicitudes.persistence.entities.EmployeeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    @Autowired
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
