package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_usuario")
    private int id;

    @Basic(optional = false)
    @Column(name = "nm_id_empleado")
    @ManyToOne
    @JoinColumn(name = "nm_id_empleado")
    private EmpleadoEntity idEmpleado;

    @Basic(optional = false)
    @Column(name = "ds_usaurio")
    private String username;

    @Basic(optional = false)
    @Column(name = "fe_fecha_creacion")
    private Date fechaCreacion;

    @Basic(optional = false)
    @Column(name = "ds_activo")
    private String activo;

    @Basic(optional = false)
    @Column(name = "ds_contraseña")
    private String password;

    @Basic(optional = false)
    @Column(name = "nm_id_rol")
    @ManyToOne
    @JoinColumn(name = "nm_id_rol")
    private RolEntity rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmpleadoEntity getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(EmpleadoEntity idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }
}


