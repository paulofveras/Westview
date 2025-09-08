package br.unitins.comics.dto;

import br.unitins.comics.model.Pessoa;

public record PessoaDTO(
    String nome,
    String cpf
) {

    public static PessoaDTO valueOf(Pessoa escritor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'valueOf'");
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public PessoaDTO getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    } 

    
}