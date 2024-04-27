package br.unitins.comics.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Escritor extends DefaultEntity{
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @ManyToMany(mappedBy = "listaEscritor")
    private List<Quadrinho> listaQuadrinhos;

    public Escritor() {

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Quadrinho> getListaQuadrinhos() {
        return listaQuadrinhos;
    }

    public void setListaQuadrinhos(List<Quadrinho> listaQuadrinhos) {
        this.listaQuadrinhos = listaQuadrinhos;
    }

    


    
    
}