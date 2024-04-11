package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.RequisitionEntity;

import java.util.List;

public interface IRequisition {
    List<RequisitionEntity> getAllSolicitudes();
    RequisitionEntity getSolicitudById(Integer id);
    Boolean createSolicitud(RequisitionEntity solicitud);
    RequisitionEntity updateSolicitud(RequisitionEntity solicitud);
    void deleteSolicitud(Integer id);


}
