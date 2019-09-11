/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.Presentation;

import br.edu.ifnmg.ArqSoft.DomainModel.Pessoa;
import br.edu.ifnmg.ArqSoft.Persistence.PessoaDAO;
import java.util.Date;

/**
 *
 * @author petronio
 */
public class Presentation_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        Pessoa p = new Pessoa();
        p.setNome("Petrônio");
        p.setCpf("92048935672");
        p.setDataAniversario(new Date());
        */
        PessoaDAO dao = new PessoaDAO();
        
        //dao.Salvar(p);
        
        Pessoa p = dao.Abrir(1);
        
        System.out.println(p.getNome());
        
        dao.Apagar(p);
    }
    
}
