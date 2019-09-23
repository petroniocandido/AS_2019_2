/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ArqSoft.DomainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author petronio
 */
@Entity
@Table(name = "Vendas")
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(scale = 2, precision = 8)
    private BigDecimal valorTotal;
    
    @ManyToOne()
    private Pessoa cliente;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    List<VendaItem> itens;

    public Venda() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<VendaItem> getItens() {
        return itens;
    }

    public void setItens(List<VendaItem> itens) {
        this.itens = itens;
    }
    
    
    public void addItem(VendaItem item){
        if(!this.itens.contains(item)){
            item.setVenda(this);
            this.itens.add(item);
            this.valorTotal.add(item.getProduto().getValor().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }
    }
    
    public void removeItem(VendaItem item){
        if(this.itens.contains(item)){
            item.setVenda(null);
            this.itens.add(item);
            this.valorTotal.subtract(item.getProduto().getValor().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }
    }
   

    @Override
    public String toString() {
        return "br.edu.ifnmg.ArqSoft.DomainModel.Venda[ id=" + id + " ]";
    }
    
}
