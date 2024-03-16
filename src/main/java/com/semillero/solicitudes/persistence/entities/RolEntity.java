package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "rol_usuario")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_rol")
    private int id;

    @Basic(optional = false)
    @Column(name = "ds_rol")
    private String rol;

    @Basic(optional = false)
    @Column(name = "fe_fecha_creacion")
    private Date fechaCreacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
