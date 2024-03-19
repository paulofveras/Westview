package br.unitins.comics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PessoaCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private Pessoa pessoa;
    private String email;
    private String telefone;
    
    public PessoaCliente() {
    }
    
    public PessoaCliente(Pessoa pessoa, String email, String telefone) {
        this.pessoa = pessoa;
        this.email = email;
        this.telefone = telefone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "PessoaCliente [id=" + id + ", pessoa=" + pessoa + ", email=" + email + ", telefone=" + telefone + "]";
    }

    

    

}
