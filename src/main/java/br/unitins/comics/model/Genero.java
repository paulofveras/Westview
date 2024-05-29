package br.unitins.comics.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Genero extends DefaultEntity{
    @Column(length = 60, nullable = false)
    private String genero;

    @Column(length = 5000, nullable = false)
    private String descricao;

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
