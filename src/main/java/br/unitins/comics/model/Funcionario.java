package br.unitins.comics.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Funcionario extends DefaultEntity {
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @Column(nullable = false)
    private String cargo;

    public Funcionario() {

    }

    public Funcionario(Pessoa pessoa, String cargo) {
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

    

    
    
}
