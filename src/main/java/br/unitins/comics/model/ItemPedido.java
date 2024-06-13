package br.unitins.comics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends DefaultEntity {
    
    private Double preco;
    private Double desconto;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_quadrinho")
    private Quadrinho quadrinho;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Quadrinho getQuadrinho() {
        return quadrinho;
    }

    public void setQuadrinho(Quadrinho quadrinho) {
        this.quadrinho = quadrinho;
    }

    
}
