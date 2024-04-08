package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "alerta")
public class AlertEntity {
    @Id
    @GeneratedValue
    @Column(name = "nm_id_alerta")
    private int id;

    @Basic(optional = false)
    @Column(name = "ds_asunto")
    private String asunto;

    @Basic(optional = false)
    @Column(name = "ds_destinatario")
    private String destinatario;

    @Basic(optional = false)
    @Column(name = "ds_contenido_alerta")
    private String contenido;

    @Basic(optional = false)
    @Column(name = "ds_estado_alerta")
    private String estado;

    @Basic(optional = false)
    @Column(name = "fe_fecha_creacion")
    private Date fecha;

    public AlertEntity() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
