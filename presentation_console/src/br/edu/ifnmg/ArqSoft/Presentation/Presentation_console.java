/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.Presentation;

import br.edu.ifnmg.ArqSoft.DomainModel.Pessoa;
import br.edu.ifnmg.ArqSoft.Persistence.PessoaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<Pessoa> pessoas = new ArrayList<>();
        
        pessoas.add(new Pessoa("Petronio","11111111111"));
        pessoas.add(new Pessoa("Maria","11111111112"));
        pessoas.add(new Pessoa("João","11111111113"));
        pessoas.add(new Pessoa("Salete","11111111114"));
        pessoas.add(new Pessoa("Marquinhos","11111111115"));
        */
        
        PessoaDAO dao = new PessoaDAO();
        
        Pessoa p = dao.AbrirPorCPF("11111111112");
        
        System.out.println(p.getNome());
        
        /*
        List<Pessoa> pessoas = dao.Buscar(new Pessoa(null, "11111111112"));
        
        for(Pessoa p : pessoas)
            System.out.println(p.getNome());
        
        */
        //@EJB
        //PessoaRepositorio dao;
        
        //dao.Salvar(p);
        
        /*
        Pessoa p = dao.Abrir(1);
        
        System.out.println(p.getNome());
        
        dao.Apagar(p);
        */
    }
    
}
