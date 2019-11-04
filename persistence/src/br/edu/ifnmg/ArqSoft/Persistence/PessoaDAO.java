/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.Persistence;

import br.edu.ifnmg.ArqSoft.DomainModel.Pessoa;
import br.edu.ifnmg.ArqSoft.DomainModel.PessoaRepositorio;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */

@Stateless(name="PessoaRepositorio")
public class PessoaDAO extends DAOGenerico<Pessoa> implements PessoaRepositorio {

    public PessoaDAO() {
        super(Pessoa.class);
    }

    @Override
    public Pessoa AbrirPorCPF(String cpf) {
        Query consulta = this.manager.createQuery("select p from Pessoa as p where p.cpf = :cpf", classe);
        consulta.setParameter("cpf", cpf);
        
        return (Pessoa) consulta.getSingleResult();
    }
    
    @Override
    public List<Pessoa> Buscar(Pessoa obj) {
        
        String jpql = "select o from " + classe.getSimpleName() + " as o";
        String where = "";
        if(obj != null){
            
            if(obj.getNome() != null)
                where += " o.nome like '%" + obj.getNome() +"%' ";
            
            if(obj.getCpf() != null){
                if(where.length() > 0) where += " and ";
                where += " o.cpf = '" + obj.getCpf() + "' ";
            }
        }
        
        if(where.length() > 0)
            jpql += " where " + where;
        
        
        Query consulta = this.manager.createQuery(jpql, classe);
        
        return consulta.getResultList();
    }
    
}
