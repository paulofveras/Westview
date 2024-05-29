package br.unitins.comics.model;

import jakarta.persistence.Entity;

@Entity
public class Origem extends DefaultEntity {
    private String pais;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    } 
}
