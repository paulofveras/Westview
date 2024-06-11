package br.unitins.comics.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class ArtistaCapa extends DefaultEntity{
    @Column(length = 60, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "artistaCapa")
    private List<Quadrinho> listaQuadrinhos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Quadrinho> getListaQuadrinhos() {
        return listaQuadrinhos;
    }

    public void setListaQuadrinhos(List<Quadrinho> listaQuadrinhos) {
        this.listaQuadrinhos = listaQuadrinhos;
    }
    
}
