package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cargos")
public class CargosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_cargo")
    private int id;

    @Basic(optional = false)
    @Column(name = "ds_cargo")
    private String cargo;

    @Basic(optional = false)
    @Column(name = "ds_descripcion")
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "fe_fecha_creacion")
    private Date fechaCreacion;

    @Basic(optional = false)
    @Column(name = "ds_activo")
    private String activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
