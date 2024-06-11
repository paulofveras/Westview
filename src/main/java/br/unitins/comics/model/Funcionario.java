package br.unitins.comics.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Funcionario extends DefaultEntity {
    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false)
    private String cargo;   

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Object getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }

}
