/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.Presentation.Controllers;

import br.edu.ifnmg.ArqSoft.DomainModel.Pessoa;
import br.edu.ifnmg.ArqSoft.DomainModel.PessoaRepositorio;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author petronio
 */
@Named(value = "pessoaController")
@SessionScoped
public class PessoaController {

    
    private Pessoa pessoa;
    
    private List<Pessoa> listagem;
    
    @EJB
    private PessoaRepositorio repositorio;
    
    /**
     * Creates a new instance of PessoaController
     */
    public PessoaController() {
       this.pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaRepositorio getRepositorio() {
        return repositorio;
    }

    public List<Pessoa> getListagem() {
        return listagem;
    }

    public void setListagem(List<Pessoa> listagem) {
        this.listagem = listagem;
    }
    
    

    public void setRepositorio(PessoaRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    
    public String Novo(){
        this.pessoa = new Pessoa();
        return "pessoaEditar.xhtml";
    }
    
    public String buscar(){
        this.listagem = repositorio.Buscar(this.getPessoa());
        return "pessoaListar.xhtml";
    }
    
}
