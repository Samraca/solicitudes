package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.AlertRepository;
import com.semillero.solicitudes.persistence.entities.AlertEntity;
import com.semillero.solicitudes.services.interfaces.IAlerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService implements IAlerta {
    private final AlertRepository alertRepository;

    @Autowired
    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public List<AlertEntity> getAllAlertas() {
        return alertRepository.findAll();
    }

    @Override
    public AlertEntity getAlertaById(Integer id) {
        return alertRepository.findById(id).orElse(null);
    }

    @Override
    public AlertEntity createAlerta(AlertEntity alerta) {
        return alertRepository.save(alerta);
    }

    @Override
    public AlertEntity updateAlerta(AlertEntity alerta) {
        return alertRepository.save(alerta);
    }

    @Override
    public void deleteAlerta(Integer id) {
        alertRepository.deleteById(id);
    }

}
