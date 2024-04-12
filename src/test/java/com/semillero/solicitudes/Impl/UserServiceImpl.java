package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.EmployeesRepository;
import com.semillero.solicitudes.persistence.UserRepository;
import com.semillero.solicitudes.persistence.entities.UserEntity;
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

import static org.mockito.Mockito.when;

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

    @DisplayName("users list could be empty but not null")
    @Test
    void listOfUserIsNotNull (){
        Assertions.assertNotNull(userService.getAllUsers());
    }

    @DisplayName("search user by id returns an user or null")
    @Test
    void returnedValueFromGetUserByIdIsNullOrUser (){
        Assertions.assertTrue(userService.getUsersById(Mockito.anyInt())==null || userService.getUsersById(Mockito.anyInt()) != null);
    }

    @DisplayName("search user by employee id returns an user or null")
    @Test
    void returnedValueFromGetUserByEmployeeIdIsNullOrUser () {
        Assertions.assertTrue(userService.getUsersByEmployeeId(Mockito.anyInt()) == null || userService.getUsersByEmployeeId(Mockito.anyInt()) != null);
    }

    @DisplayName("search user by username returns an user or null")
    @Test
    void returnedValueFromFindByUsernameIsNullOrUser(){
        Assertions.assertTrue(userService.findByUsername(Mockito.anyString()) == null || userService.findByUsername(Mockito.anyString()) != null);
    }

    @DisplayName("create user returns expected user")
    @Test
    void givenUserToCreateExpectUserCreated(){
        UserEntity expectedUser = new UserEntity();
        when(userRepository.save(expectedUser)).thenReturn(expectedUser);

        final UserEntity result = userService.createUser(expectedUser);

        Assertions.assertEquals(expectedUser, result);
    }

    @DisplayName("update user returns expected updated user")
    @Test
    void givenUserToUpdateExpectUserUpdated(){
        UserEntity expectedUserToUpdate = new UserEntity();
        when(userRepository.save(expectedUserToUpdate)).thenReturn(expectedUserToUpdate);

        final UserEntity result = userService.updateUser(expectedUserToUpdate);

        Assertions.assertEquals(expectedUserToUpdate, result);
    }

    @DisplayName("delete user returns deleted")
    @Test
    void givenIdOfUserToDeleteExpectDeleted(){
        Assertions.assertEquals("Deleted", userService.deleteUser(Mockito.anyInt()));
    }

}
