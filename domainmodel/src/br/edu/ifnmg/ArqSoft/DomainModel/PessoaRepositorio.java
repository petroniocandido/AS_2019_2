/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.DomainModel;

/**
 *
 * @author petronio
 */
public interface PessoaRepositorio extends Repositorio<Pessoa> {
    public Pessoa AbrirPorCPF(String cpf);
}
