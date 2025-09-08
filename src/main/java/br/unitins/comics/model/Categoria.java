package br.unitins.comics.model;

import jakarta.persistence.Entity;

@Entity
public class Categoria {
    private Long id;
    private String universo;
    
    public Categoria() {
    }

    public Categoria(Long id, String universo) {
        this.id = id;
        this.universo = universo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }
    
    
}
