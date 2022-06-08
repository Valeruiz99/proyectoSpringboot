package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service;

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.EncabezadoPedido;

public interface IEncabezadoPedidoService {
    
    public List<EncabezadoPedido> findAll();

    public void save (EncabezadoPedido encabezadoPedido);

    public EncabezadoPedido findOne(Long idEncabezadoPedido);

    public void deletePedidos(Long idEncabezadoPedido);
}
