package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;
//Se le pone una "I" al inicio, porque vamos a crear una interfaz
//DAO, Organización Autónoma Descentralizada, Objeto, de Acceso a Datos

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Cliente;

public interface IClienteDao {//La interface, es para comunicarnos con la base de datos,
    // nos va a retornar una lista de clientes que es la entity, y ésta se comunica con la base de datos.

    public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findOne(Long id);
    
    public void delete(Long id);
}
