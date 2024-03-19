package br.unitins.comics.dto;

import br.unitins.comics.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PessoaClienteDTO {
    @NotBlank(message = "Campo Obrigatório")
    private Pessoa pessoa;
    private String email;
    @NotNull(message = "Telefone Obrigatório.")
    private String telefone;

    public PessoaClienteDTO() {
    }

    public PessoaClienteDTO(Pessoa pessoa, String email, String telefone) {
        this.pessoa = pessoa;
        this.email = email;
        this.telefone = telefone;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "PessoaCliente [pessoa=" + pessoa + ", email=" + email + ", telefone=" + telefone + "]";
    }
}
