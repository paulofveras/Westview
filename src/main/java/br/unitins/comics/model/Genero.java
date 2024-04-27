package br.unitins.comics.model;

import jakarta.persistence.Entity;

@Entity
public class Genero extends DefaultEntity{
    private String genero;
    private String descricao;

    public Genero() {

    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
