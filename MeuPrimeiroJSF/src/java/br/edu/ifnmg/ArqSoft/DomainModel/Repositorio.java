/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.DomainModel;

import java.util.List;

/**
 *
 * @author petronio
 */
public interface Repositorio<T> {
    
    public boolean Salvar(T obj);
    public boolean Apagar(T obj);
    public T Abrir(int id);
    public List<T> Buscar(T obj);
    
}
