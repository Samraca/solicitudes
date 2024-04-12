package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.UserRepository;
import com.semillero.solicitudes.persistence.entities.EmployeeEntity;
import com.semillero.solicitudes.persistence.EmployeesRepository;
import com.semillero.solicitudes.persistence.entities.UserEntity;
import com.semillero.solicitudes.services.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUser {
    private final UserRepository userRepository;
    private final EmployeesRepository employeesRepository;

    @Autowired
    public UserService(UserRepository userRepository, EmployeesRepository employeesRepository) {
        this.userRepository = userRepository;
        this.employeesRepository = employeesRepository;
    }

    @Override
    public List<UserEntity> getAllUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUsuarioById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity getUsuarioByEmpleadoId(Integer empleadoId) {
        EmployeeEntity empleado = employeesRepository.findById(empleadoId).orElse(null);
        return userRepository.findByEmpleadoId(empleado);
    }

    @Override
    public UserEntity createUsuario(UserEntity usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public UserEntity updateUsuario(UserEntity usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public String deleteUsuario(Integer id) {
        try{
            userRepository.deleteById(id);
            return "Deleted";
        }catch(Exception exception){
            return "Error: "+exception;
        }
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
