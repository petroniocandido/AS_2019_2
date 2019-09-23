/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.Persistence;

import br.edu.ifnmg.ArqSoft.DomainModel.Repositorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
public abstract class DAOGenerico<T> implements Repositorio<T> {
    
    private EntityManagerFactory factory;
    protected EntityManager manager;
    protected Class classe;

    public DAOGenerico(Class t) {
        classe = t;
        factory = Persistence.createEntityManagerFactory("ArqSoft");
        manager = factory.createEntityManager();
    }

    @Override
    public void Salvar(T obj) {
        // Pega uma transação com o manager
        EntityTransaction transaction = manager.getTransaction();
        
        // Iniciar a transação
        transaction.begin();
        
        // Persistir o objeto
        manager.persist(obj);
        
        // Finalizar transação
        transaction.commit();
    }

    @Override
    public T Abrir(long id) {
        
        return (T) manager.find(classe, id);
        
    }

    @Override
    public void Apagar(T obj) {
        // Pega uma transação com o manager
        EntityTransaction transaction = manager.getTransaction();
        
        // Iniciar a transação
        transaction.begin();
        
        // Persistir o objeto
        manager.remove(obj);
        
        // Finalizar transação
        transaction.commit();
    }

   
    
}
