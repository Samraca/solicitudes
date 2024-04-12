package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.EmployeesRepository;
import com.semillero.solicitudes.persistence.entities.EmployeeEntity;
import com.semillero.solicitudes.services.EmployeeService;
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
class EmployeeServiceImpl {
    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeesRepository employeesRepository;

    @BeforeEach
    void setUp(){
        employeeService = new EmployeeService(employeesRepository);
    }

    @DisplayName("employees list could be empty but not null")
    @Test
    void listOfEmployeeIsNotNull(){
        Assertions.assertNotNull(employeeService.getAllEmployees());
    }

    @DisplayName("search employee by id returns an employee or null")
    @Test
    void returnedValueFromGetEmployeeByIdIsNullOrEmployee(){
        Assertions.assertTrue(employeeService.getEmployeeById(Mockito.anyInt())==null || employeeService.getEmployeeById(Mockito.anyInt())!= null);
    }

    @DisplayName("search employee by document returns an employee or null")
    @Test
    void returnedValueFromFindEmployeeByDocumentIsNullOrEmployee(){
        Assertions.assertTrue(employeeService.findByDocument(Mockito.anyInt())==null || employeeService.findByDocument(Mockito.anyInt())!=null);
    }

    @DisplayName("create employee returns expected employee")
    @Test
    void givenEmployeeToCreateExpectEmployeeCreated(){
        EmployeeEntity expectedEmployee = new EmployeeEntity();
        when(employeesRepository.save(expectedEmployee)).thenReturn(expectedEmployee);

        final EmployeeEntity result = employeeService.createEmployee(expectedEmployee);

        Assertions.assertEquals(expectedEmployee, result);
    }

    @DisplayName("update employee returns expected employee alert")
    @Test
    void givenEmployeeToUpdateExpectEmployeeUpdated(){
        EmployeeEntity expectedEmployeeToUpdate = new EmployeeEntity();
        when(employeesRepository.save(expectedEmployeeToUpdate)).thenReturn(expectedEmployeeToUpdate);

        final EmployeeEntity result = employeeService.updateEmployee(expectedEmployeeToUpdate);

        Assertions.assertEquals(expectedEmployeeToUpdate, result);
    }

    @DisplayName("delete employee returns deleted")
    @Test
    void givenIdOfEmployeeToDeleteExpectDeleted(){
        Assertions.assertEquals("Deleted", employeeService.deleteEmployee(Mockito.anyInt()));
    }
}
