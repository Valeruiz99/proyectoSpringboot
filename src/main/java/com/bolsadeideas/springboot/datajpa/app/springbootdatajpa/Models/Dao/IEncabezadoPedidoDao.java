package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.EncabezadoPedido;

public interface IEncabezadoPedidoDao {
    
    public List<EncabezadoPedido> findAll();

    public void save (EncabezadoPedido encabezadoPedido);

    public EncabezadoPedido findOne(Long idEncabezadoPedido);

    public void deletePedidos(Long idEncabezadoPedido);

}
