package br.unitins.comics.dto;

import br.unitins.comics.model.Pessoa;

public class PessoaFuncionarioDTO {
    private Pessoa pessoa;
    private String cargo;

    public PessoaFuncionarioDTO() {
    }

    public PessoaFuncionarioDTO(Pessoa pessoa, String cargo) {
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
        return "PessoaFuncionario [pessoa=" + pessoa + ", cargo=" + cargo + "]";
    }

    
}
