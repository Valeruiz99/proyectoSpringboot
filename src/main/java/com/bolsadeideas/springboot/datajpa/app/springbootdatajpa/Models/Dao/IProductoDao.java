package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;

public interface IProductoDao {

    public List<Producto> findAll();

    public void save(Producto producto);

    public Producto findOne(Long id);

    public void deleteProductos (Long id);
    
}
