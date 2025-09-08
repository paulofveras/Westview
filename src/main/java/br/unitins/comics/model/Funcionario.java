package br.unitins.comics.model;

import jakarta.persistence.Entity;

@Entity
public class Funcionario {
    private Long id;
    private Pessoa pessoa;
    
    public Funcionario() {
    }

    public Funcionario(Long id, Pessoa pessoa) {
        this.id = id;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
}
