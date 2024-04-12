package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.RequisitionEntity;

import java.util.List;

public interface IRequisition {
    List<RequisitionEntity> getAllRequisitions();
    RequisitionEntity getRequisitionById(Integer id);
    Boolean createRequisition(RequisitionEntity solicitud);
    RequisitionEntity updateRequisition(RequisitionEntity solicitud);
    String deleteRequisition(Integer id);


}
