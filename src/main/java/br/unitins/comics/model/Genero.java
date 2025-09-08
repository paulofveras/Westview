package br.unitins.comics.model;

import jakarta.persistence.Entity;

@Entity
public class Genero {
    private Long id;
    private String genero;
    private String descricao;
    
    public Genero() {
    }

    public Genero(Long id, String genero, String descricao) {
        this.id = id;
        this.genero = genero;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
