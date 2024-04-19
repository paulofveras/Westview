package br.unitins.comics.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa extends DefaultEntity {
    private String nome;
    private String cpf;
    private String email;

    @OneToMany(mappedBy = "pessoa")
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "pessoa")
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "pessoa")
    private List<Escritor> escritores;

    @OneToMany(mappedBy = "pessoa")
    private List<ArtistaCapa> artistasCapa;

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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Escritor> getEscritores() {
        return escritores;
    }

    public void setEscritores(List<Escritor> escritores) {
        this.escritores = escritores;
    }

    public List<ArtistaCapa> getArtistasCapa() {
        return artistasCapa;
    }

    public void setArtistasCapa(List<ArtistaCapa> artistasCapa) {
        this.artistasCapa = artistasCapa;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", funcionarios=" + funcionarios
                + ", clientes=" + clientes + ", escritores=" + escritores + ", artistasCapa=" + artistasCapa + "]";
    }

    
   
}
