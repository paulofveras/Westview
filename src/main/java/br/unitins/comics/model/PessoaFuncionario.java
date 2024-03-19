package br.unitins.comics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PessoaFuncionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private Pessoa pessoa;
    private String cargo;
    
    public PessoaFuncionario() {
    }

    public PessoaFuncionario(Pessoa pessoa, String cargo) {
        this.pessoa = pessoa;
        this.cargo = cargo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "PessoaFuncionario [id=" + id + ", pessoa=" + pessoa + ", cargo=" + cargo + "]";
    }

    

    
}
