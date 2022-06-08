package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name = "encabezadoPedido")
public class EncabezadoPedido implements Serializable{
    
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id_encabezado_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEncabezadoPedido;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    
    @NotNull
    @Column(name = "celular_destino")
    private long celularDestino;

    @NotEmpty
    @Column(name = "direccion_destino")
    private String direccionDestino;

    @NotEmpty
    @Column(name = "nombre_destino")
    private String nombreDestino;

    @NotNull
    private int subtotal;

    @NotNull
    private int total;

    @NotNull
    private int descuento;

    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;

    @NotNull
    private String estado;

    public Long getIdEncabezadoPedido() {
        return idEncabezadoPedido;
    }

    public void setIdEncabezadoPedido(Long idEncabezadoPedido) {
        this.idEncabezadoPedido = idEncabezadoPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getCelularDestino() {
        return celularDestino;
    }

    public void setCelularDestino(long celularDestino) {
        this.celularDestino = celularDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
