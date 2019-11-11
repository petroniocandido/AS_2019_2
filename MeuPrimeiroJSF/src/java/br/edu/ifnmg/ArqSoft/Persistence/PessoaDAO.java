/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.Persistence;

import br.edu.ifnmg.ArqSoft.DomainModel.Pessoa;
import br.edu.ifnmg.ArqSoft.DomainModel.PessoaRepositorio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author petronio
 */
@Stateless
public class PessoaDAO implements PessoaRepositorio {
    
    @PersistenceUnit(name = "MeuPrimeiroJSFPU")
    EntityManager gerenciador;

    @Override
    public boolean Salvar(Pessoa obj) {
        EntityTransaction transacao = gerenciador.getTransaction();
        try {
            gerenciador.persist(obj);
            transacao.commit();
            return true;
        } catch(Exception ex){
           transacao.rollback();
        }
        return false;
    }

    @Override
    public boolean Apagar(Pessoa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa Abrir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> Buscar(Pessoa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
