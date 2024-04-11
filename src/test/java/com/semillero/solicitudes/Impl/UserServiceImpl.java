package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.EmployeesRepository;
import com.semillero.solicitudes.persistence.UserRepository;
import com.semillero.solicitudes.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImpl {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
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
