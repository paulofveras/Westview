package br.unitins.comics.model;

import jakarta.persistence.Entity;

@Entity
public class Origem extends DefaultEntity {
    private String pais;

    public Origem() {

    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    
}
