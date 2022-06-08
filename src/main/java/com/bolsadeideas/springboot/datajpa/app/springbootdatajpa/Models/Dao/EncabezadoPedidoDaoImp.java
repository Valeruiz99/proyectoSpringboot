package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.EncabezadoPedido;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("encabezadoPedidoJPA")
public class EncabezadoPedidoDaoImp implements IEncabezadoPedidoDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional (readOnly = true)
    @Override
    public List<EncabezadoPedido> findAll() {
        return em.createQuery("from EncabezadoPedido").getResultList();
    }

    @Override
    @Transactional
    public void save(EncabezadoPedido encabezadoPedido) {
        if(encabezadoPedido.getId() != null && encabezadoPedido.getId()>0){
            em.merge(encabezadoPedido);
        }else{
            em.persist(encabezadoPedido);
        }
    }

    @Transactional
    @Override
    public EncabezadoPedido findOne(Long idEncabezadoPedido) {
        return em.find(EncabezadoPedido.class, idEncabezadoPedido);
    }

    @Transactional
    @Override
    public void deletePedidos(Long idEncabezadoPedido) {
        
        EncabezadoPedido encabezadoPedido = findOne(idEncabezadoPedido);
        em.remove(encabezadoPedido);
    }
    
}
