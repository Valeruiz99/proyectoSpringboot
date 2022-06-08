package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="producto")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @NotEmpty
    private String nombre;

    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @PrePersist
    public void PrePersist(){
        fecha = new Date();
    }

    @NotEmpty
    private String cantidad;

    @NotNull
    @Column(name = "precio_venta")
    private long precioDeVenta;

    @NotNull
    @Column(name = "precio_compra")
    private long precioDeCompra;

    public Long getId() {
        return idProducto;
    }

    public void setId(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(Long precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public Long getPrecioDeCompra() {
        return precioDeCompra;
    }

    public void setPrecioDeCompra(Long precioDeCompra) {
        this.precioDeCompra = precioDeCompra;
    }

}
