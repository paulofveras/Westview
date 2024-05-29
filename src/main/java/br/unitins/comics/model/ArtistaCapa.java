package br.unitins.comics.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ArtistaCapa extends DefaultEntity{
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;


    @OneToMany(mappedBy = "artistaCapa")
    private List<Quadrinho> quadrinhos;

    public Pessoa getPessoa() {
        return pessoa;
    }


    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


    public List<Quadrinho> getQuadrinhos() {
        return quadrinhos;
    }


    public void setQuadrinhos(List<Quadrinho> quadrinhos) {
        this.quadrinhos = quadrinhos;
    }
}
