package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service;

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao.IProductoDao;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductoServiceImp implements IProductoService{

    @Autowired
    private IProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll(){
        return productoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Producto producto){
        productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findOne(Long id){
        return productoDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteProductos(Long id){
        productoDao.deleteProductos(id);
    }



    
}
