package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.CargosEntity;

import java.util.List;

public interface ICargo {
    List<CargosEntity> getAllCargos();

    CargosEntity getCargoById(Integer id);

    CargosEntity createCargo(CargosEntity cargo);

    CargosEntity updateCargo(CargosEntity cargo);

    void deleteCargo(Integer id);
}
