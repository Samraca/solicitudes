package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "solicitud_vaciones")
public class RequisitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_solicitud")
    private int id;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "nm_id_usuario")
    private UserEntity usuario;

    @Basic(optional = false)
    @Column(name = "nm_dias_solicita")
    private int diasSolicitados;

    @Basic(optional = false)
    @Column(name = "fe_fecha_inicio")
    private Date fechaInicio;

    @Basic(optional = false)
    @Column(name = "fe_fecha_fin")
    private Date fechaFin;

    @Basic(optional = false)
    @Column(name = "fe_fecha_retorna")
    private Date fechaRetorno;

    @Basic(optional = false)
    @Column(name = "ds_estado")
    private String estado;

    @Basic(optional = false)
    @Column(name = "ds_observaciones")
    private String observaciones;

    @Basic(optional = false)
    @Column(name = "fe_fecha_creacion")
    private Date fechaCreacion;

    public RequisitionEntity() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public int getDiasSolicitados() {
        return diasSolicitados;
    }

    public void setDiasSolicitados(int diasSolicitados) {
        this.diasSolicitados = diasSolicitados;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
