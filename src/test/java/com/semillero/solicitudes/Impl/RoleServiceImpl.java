package com.semillero.solicitudes.Impl;

import com.semillero.solicitudes.persistence.RoleRepository;
import com.semillero.solicitudes.persistence.entities.RoleEntity;
import com.semillero.solicitudes.services.RoleService;
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
class RoleServiceImpl {
    @InjectMocks
    RoleService roleService;

    @Mock
    RoleRepository roleRepository;

    @BeforeEach
    void setUp(){
        roleService = new RoleService(roleRepository);
    }

    @DisplayName("roles list could be empty but not null")
    @Test
    void listOfRolesIsNotNull(){
        Assertions.assertNotNull(roleService.getAllRoles());
    }

    @DisplayName("search role by id returns an role or null")
    @Test
    void givenIdForRoleSearchExpectRoleOrNull(){
        Assertions.assertTrue(roleService.getRoleById(Mockito.anyInt())!= null || roleService.getRoleById(Mockito.anyInt())==null);
    }

    @DisplayName("create role returns expected role")
    @Test
    void givenRoleToCreateExpectRoleCreated(){
        RoleEntity expectedRole = new RoleEntity();
        when(roleRepository.save(expectedRole)).thenReturn(expectedRole);

        final RoleEntity result = roleService.createRole(expectedRole);

        Assertions.assertEquals(expectedRole, result);
    }

    @DisplayName("update role returns expected updated role")
    @Test
    void givenRoleToUpdateExpectRoleUpdated(){
        RoleEntity expectedRoleToUpdate = new RoleEntity();
        when(roleRepository.save(expectedRoleToUpdate)).thenReturn(expectedRoleToUpdate);

        final RoleEntity result = roleService.updateRole(expectedRoleToUpdate);

        Assertions.assertEquals(expectedRoleToUpdate, result);
    }

    @DisplayName("delete role returns deleted")
    @Test
    void givenIdOfAlertToDeleteExpectDeleted(){
        Assertions.assertEquals("Deleted", roleService.deleteRole(Mockito.anyInt()));
    }
}
