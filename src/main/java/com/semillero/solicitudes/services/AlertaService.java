package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.AlertaRepository;
import com.semillero.solicitudes.persistence.entities.AlertaEntity;
import com.semillero.solicitudes.services.interfaces.IAlerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService implements IAlerta {
    private final AlertaRepository alertaRepository;

    @Autowired
    public AlertaService(AlertaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    @Override
    public List<AlertaEntity> getAllAlertas() {
        return alertaRepository.findAll();
    }

    @Override
    public AlertaEntity getAlertaById(Integer id) {
        return alertaRepository.findById(id).orElse(null);
    }

    @Override
    public AlertaEntity createAlerta(AlertaEntity alerta) {
        return alertaRepository.save(alerta);
    }

    @Override
    public AlertaEntity updateAlerta(AlertaEntity alerta) {
        return alertaRepository.save(alerta);
    }

    @Override
    public void deleteAlerta(Integer id) {
        alertaRepository.deleteById(id);
    }

}
