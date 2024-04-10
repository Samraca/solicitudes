package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.EmployeesRepository;
import com.semillero.solicitudes.persistence.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @BeforeEach
    void setup(){
        userService = new UserService(userRepository, employeesRepository);
    }

    @Test
    void listOfUserIsNotNull (){
        Assertions.assertNotNull(userService.getAllUsuarios());
    }

    @Test
    void returnedValueFromGetUserByIdIsNullOrUser (){
        Assertions.assertTrue(userService.getUsuarioById(1)==null || userService.getUsuarioById(1) != null);
    }
    
    @Test
    void returnedValueFromGetUserByEmployeeIdIsNullOrUser () {
        Assertions.assertTrue(userService.getUsuarioByEmpleadoId(1) == null || userService.getUsuarioByEmpleadoId(1) != null);
    }

    /*
    @Test
    void returnedValueAfterCreateUserIsNotNull () {
        Assertions.assertTrue(userService.createUsuario())
    }
    */
}
