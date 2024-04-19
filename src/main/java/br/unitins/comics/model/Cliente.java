package br.unitins.comics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cliente extends DefaultEntity{
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    public Cliente() {

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
}
