package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.AlertEntity;

import java.util.List;

public interface IAlert {
    List<AlertEntity> getAllAlertas();

    AlertEntity getAlertaById(Integer id);

    AlertEntity createAlerta(AlertEntity alerta);

    AlertEntity updateAlerta(AlertEntity alerta);

    String deleteAlerta(Integer id);

}
