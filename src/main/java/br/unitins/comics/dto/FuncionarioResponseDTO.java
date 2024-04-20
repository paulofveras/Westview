package br.unitins.comics.dto;

import br.unitins.comics.model.Funcionario;

public record FuncionarioResponseDTO (
    Long id,
    PessoaResponseDTO pessoa
) {
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            PessoaResponseDTO.fromPessoa(funcionario.getPessoa())
        );
    }
}