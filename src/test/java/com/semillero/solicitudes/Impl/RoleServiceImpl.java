package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.RoleRepository;
import com.semillero.solicitudes.services.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RoleServiceImpl {
    @InjectMocks
    RoleService roleService;

    @Mock
    RoleRepository roleRepository;

    @BeforeEach
    void setUp(){
        roleService = new RoleService(roleRepository);
    }

    @Test
    void listOfRolesIsNotNull(){
        Assertions.assertNotNull(roleService.getAllRoles());
    }
}
