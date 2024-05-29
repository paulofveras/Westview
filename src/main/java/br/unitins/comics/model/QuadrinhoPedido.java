package br.unitins.comics.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class QuadrinhoPedido extends DefaultEntity {
    
    private Double preco;
    private Double desconto;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_quadrinho")
    private Quadrinho quadrinhos;

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
        return quadrinhos;
    }

    public void setQuadrinho(Quadrinho quadrinho) {
        this.quadrinhos = quadrinho;
    }

    
}
