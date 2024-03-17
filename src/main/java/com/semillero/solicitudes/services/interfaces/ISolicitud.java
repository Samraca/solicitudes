package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.SolicitudEntity;

import java.util.List;

public interface ISolicitud {
    List<SolicitudEntity> getAllSolicitudes();
    SolicitudEntity getSolicitudById(Integer id);
    SolicitudEntity createSolicitud(SolicitudEntity solicitud);
    SolicitudEntity updateSolicitud(SolicitudEntity solicitud);
    void deleteSolicitud(Integer id);


}
