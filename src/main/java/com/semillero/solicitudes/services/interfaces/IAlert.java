package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.AlertEntity;

import java.util.List;

public interface IAlert {
    List<AlertEntity> getAllAlerts();

    AlertEntity getAlertsById(Integer id);

    AlertEntity createAlert(AlertEntity alerta);

    AlertEntity updateAlert(AlertEntity alerta);

    String deleteAlert(Integer id);

}
