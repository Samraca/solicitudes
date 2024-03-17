package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.CargosRepository;
import com.semillero.solicitudes.persistence.entities.CargosEntity;
import com.semillero.solicitudes.services.interfaces.ICargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService implements ICargo {

    private final CargosRepository cargoRepository;

    @Autowired
    public CargoService(CargosRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<CargosEntity> getAllCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public CargosEntity getCargoById(Integer id) {
        return cargoRepository.findById(id).orElse(null);
    }

    @Override
    public CargosEntity createCargo(CargosEntity cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public CargosEntity updateCargo(CargosEntity cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public void deleteCargo(Integer id) {
        cargoRepository.deleteById(id);
    }

}
