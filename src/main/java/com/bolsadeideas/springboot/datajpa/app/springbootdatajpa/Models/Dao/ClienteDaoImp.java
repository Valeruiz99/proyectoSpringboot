package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Cliente;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//Lo que acaba de implementar o heredar el método de Cliente
@Repository("ClienteDaoJPA")
public class ClienteDaoImp implements IClienteDao {
    
    @PersistenceContext//contexto de cómo va a ser la persistencia de datos
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override//SobreEscribir
    public List<Cliente> findAll() {
    
        return em.createQuery("from Cliente").getResultList();//Creamos un Query, una consulta a la base de datos que genera una lista, y nos la trae.
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        
        if(cliente.getId() != null && cliente.getId()>0){

            em.merge(cliente);

        }else{
            em.persist(cliente);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class,id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        Cliente cliente = findOne(id);
        em.remove(cliente);
    }

    

   

    
}
