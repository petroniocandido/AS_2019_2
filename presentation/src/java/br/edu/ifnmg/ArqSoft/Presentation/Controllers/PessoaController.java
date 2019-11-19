/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.Presentation.Controllers;

import br.edu.ifnmg.ArqSoft.DomainModel.Pessoa;
import br.edu.ifnmg.ArqSoft.DomainModel.PessoaRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author petronio
 */
@ManagedBean(name = "pessoaController")
@SessionScoped
public class PessoaController implements Serializable  {

    
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
        return this.repositorio;
    }

    public List<Pessoa> getListagem() {
        if(listagem == null)
            this.listagem = repositorio.Buscar(pessoa);
        return this.listagem;
    }

    public void setListagem(List<Pessoa> listagem) {
        this.listagem = listagem;
    }
    
    public void setRepositorio(PessoaRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    
    public String editar(int id){
        this.pessoa = repositorio.Abrir(id);
        return "pessoaEditar.xhtml";
    }
    
    public String novo(){
        this.pessoa = new Pessoa();
        return "pessoaEditar.xhtml";
    }
    
    public String buscar(){
        this.listagem = repositorio.Buscar(this.getPessoa());
        return "pessoaListar.xhtml";
    }
    
    public void salvar(){
        repositorio.Salvar(pessoa);
    }
    
    public String cancelar() {
        pessoa = new Pessoa();
        return "pessoaListar.xhtml";
    }
    
    public String apagar() {
        repositorio.Apagar(pessoa);
        return "pessoaListar.xhtml";
    }
    
}
