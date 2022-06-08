package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service;

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao.IEncabezadoPedidoDao;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.EncabezadoPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EncabezadoPedidoServiceImp implements IEncabezadoPedidoService{

    @Autowired
    private IEncabezadoPedidoDao encabezadoPedidoDao;

    @Override
    @Transactional(readOnly = true)
    public List<EncabezadoPedido> findAll() {
        return encabezadoPedidoDao.findAll();
    }

    @Override
    @Transactional
    public void save(EncabezadoPedido encabezadoPedido) {
        encabezadoPedidoDao.save(encabezadoPedido);
    }

    @Override
    @Transactional(readOnly = true)
    public EncabezadoPedido findOne(Long idEncabezadoPedido) {
        return encabezadoPedidoDao.findOne(idEncabezadoPedido);
    }

    @Override
    @Transactional
    public void deletePedidos(Long idEncabezadoPedido) {
        encabezadoPedidoDao.deletePedidos(idEncabezadoPedido);
    }

    
    
}
