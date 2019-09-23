/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.Persistence;

import br.edu.ifnmg.ArqSoft.DomainModel.Venda;
import br.edu.ifnmg.ArqSoft.DomainModel.VendaRepositorio;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
public class VendaDAO extends DAOGenerico<Venda> implements VendaRepositorio {

    public VendaDAO() {
        super(Venda.class);
    }

    @Override
    public List<Venda> Buscar(Venda obj) {
          String jpql = "select v from Venda as v join Pessoa as p on v.pessoa = p";
        String where = "";
        if(obj != null){
            
            if(obj.getCliente()!= null)
                where += " p.id = " + obj.getCliente().getId();
            
        }
        
        if(where.length() > 0)
            jpql += " where " + where;
        
        
        Query consulta = this.manager.createQuery(jpql, classe);
        
        return consulta.getResultList();
    }
    
    
    
}
