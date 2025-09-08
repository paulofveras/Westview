package br.unitins.comics.model;

import jakarta.persistence.Entity;

@Entity
public class Origem {
    private Long id;
    private String pais;
    
    public Origem() {
    }

    public Origem(Long id, String pais) {
        this.id = id;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    
}
