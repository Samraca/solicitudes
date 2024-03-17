package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.AlertaEntity;

import java.util.List;

public interface IAlerta {
    List<AlertaEntity> getAllAlertas();

    AlertaEntity getAlertaById(Integer id);

    AlertaEntity createAlerta(AlertaEntity alerta);

    AlertaEntity updateAlerta(AlertaEntity alerta);

    void deleteAlerta(Integer id);

}
