package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "empleado")
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_empleado")
    private int id;

    @Basic(optional = false)
    @Column(name = "nm_documento")
    private int documento;

    @Basic(optional = false)
    @Column(name = "ds_tipo_documento")
    private String tipoDocumento;

    @Basic(optional = false)
    @Column(name = "ds_nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "ds_apellido")
    private String apellido;

    @Basic(optional = false)
    @Column(name = "ds_telefono")
    private String telefono;

    @Basic(optional = false)
    @Column(name = "ds_direccion")
    private String direccion;

    @Basic(optional = false)
    @Column(name = "fe_fecha_ingreso")
    private Date fechaIngreso;

    @Basic(optional = true)
    @Column(name = "fe_fecha_retiro")
    private Date fechaRetiro;

    @Basic(optional = false)
    @Column(name = "ds_tipo_contrato")
    private String tipoContrato;

    @Basic(optional = false)
    @Column(name = "ds_estado_empleado")
    private String estado;

    @Basic(optional = true)
    @Column(name = "nm_supervisor_inmediato")
    @ManyToOne
    @JoinColumn(name = "nm_supervisor_inmediato")
    private EmpleadoEntity supervisor;

    @Basic(optional = false)
    @Column(name = "nm_cargo")
    @ManyToOne
    @JoinColumn(name = "nm_id_cargo")
    private CargosEntity cargo;

    public EmpleadoEntity() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EmpleadoEntity getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(EmpleadoEntity supervisor) {
        this.supervisor = supervisor;
    }

    public CargosEntity getCargo() {
        return cargo;
    }

    public void setCargo(CargosEntity cargo) {
        this.cargo = cargo;
    }
}
