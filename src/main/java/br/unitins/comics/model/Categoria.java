package br.unitins.comics.model;

import jakarta.persistence.Entity;

@Entity
public class Categoria extends DefaultEntity {
    
    private String universo;
    
    public Categoria() {
    }

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }

    public void setId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
