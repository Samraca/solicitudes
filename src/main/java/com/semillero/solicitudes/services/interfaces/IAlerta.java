package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.AlertEntity;

import java.util.List;

public interface IAlerta {
    List<AlertEntity> getAllAlertas();

    AlertEntity getAlertaById(Integer id);

    AlertEntity createAlerta(AlertEntity alerta);

    AlertEntity updateAlerta(AlertEntity alerta);

    void deleteAlerta(Integer id);

}
