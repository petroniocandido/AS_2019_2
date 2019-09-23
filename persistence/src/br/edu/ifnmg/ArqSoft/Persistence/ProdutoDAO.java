/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.Persistence;

import br.edu.ifnmg.ArqSoft.DomainModel.Produto;
import br.edu.ifnmg.ArqSoft.DomainModel.ProdutoRepositorio;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
public class ProdutoDAO extends DAOGenerico<Produto> implements ProdutoRepositorio {

    public ProdutoDAO() {
        super(Produto.class);
    }
    
    @Override
    public List<Produto> Buscar(Produto obj) {
          
        String jpql = "select o from Produto as o";
        String where = "";
        if(obj != null){
            
            if(obj.getNome() != null)
                where += " o.nome like '%" + obj.getNome() +"%' ";
            
            if(obj.getValor()!= null){
                if(where.length() > 0) where += " and ";
                where += " o.valor = " + obj.getValor() ;
            }
            
            if(obj.getEstoque() != 0){
                if(where.length() > 0) where += " and ";
                where += " o.estoque = " + obj.getEstoque() + " ";
            }
        }
        
        if(where.length() > 0)
            jpql += " where " + where;
        
        
        Query consulta = this.manager.createQuery(jpql, classe);
        
        return consulta.getResultList();
    }
    
}
