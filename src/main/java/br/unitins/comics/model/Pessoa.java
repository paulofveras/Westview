package br.unitins.comics.model;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Pessoa extends DefaultEntity {

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(length = 100)
    private String nome;
    private String cpf;
    private String email;

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
