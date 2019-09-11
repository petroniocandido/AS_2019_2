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
    
    public void Salvar(T obj);
    
    public T Abrir(long id);
    
    public void Apagar(T obj);
    
    public List<T> Buscar(T obj);
    
}
