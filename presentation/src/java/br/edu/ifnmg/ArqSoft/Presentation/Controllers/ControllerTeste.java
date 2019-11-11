package br.edu.ifnmg.ArqSoft.Presentation.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifnmg.ArqSoft.DomainModel.Pessoa;
import br.edu.ifnmg.ArqSoft.DomainModel.PessoaRepositorio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author petronio
 */
@Named(value = "controllerTeste")
@SessionScoped
public class ControllerTeste implements Serializable {
    
    private Pessoa pessoa;
    
    @EJB
    PessoaRepositorio dao;

    /**
     * Creates a new instance of ControllerTeste
     */
    public ControllerTeste() {
        pessoa = new Pessoa("   ", "00000000000");
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public void salvar(){
        dao.Salvar(pessoa);
    }
    
}
