package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.AlertRepository;
import com.semillero.solicitudes.persistence.entities.AlertEntity;
import com.semillero.solicitudes.services.interfaces.IAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertService implements IAlert {
    private final AlertRepository alertRepository;

    @Autowired
    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public List<AlertEntity> getAllAlerts() {
        return alertRepository.findAll();
    }

    @Override
    public AlertEntity getAlertsById(Integer id) {
        return alertRepository.findById(id).orElse(null);
    }

    @Override
    public AlertEntity createAlert(AlertEntity alerta) {
        return alertRepository.save(alerta);
    }

    @Override
    public AlertEntity updateAlert(AlertEntity alerta) {
        return alertRepository.save(alerta);
    }

    @Override
    public String deleteAlert(Integer id) {
        try{
            alertRepository.deleteById(id);
            return "Deleted";
        }catch(Exception exception){
            return "Error: "+exception;
        }

    }

}
