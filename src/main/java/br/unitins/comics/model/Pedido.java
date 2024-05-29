package br.unitins.comics.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Pedido extends DefaultEntity {
    private LocalDateTime data;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_quadrinho")
    private List<QuadrinhoPedido> quadrinhos;

    public LocalDateTime getData() {
        return data;
    }


    public void setData(LocalDateTime data) {
        this.data = data;
    }


    public Double getTotal() {
        return total;
    }


    public void setTotal(Double total) {
        this.total = total;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public List<QuadrinhoPedido> getQuadrinhos() {
        return quadrinhos;
    }


    public void setQuadrinhos(List<QuadrinhoPedido> quadrinhos) {
        this.quadrinhos = quadrinhos;
    }
    
    
}
