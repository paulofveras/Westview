package br.unitins.comics.dto;

import br.unitins.comics.model.Funcionario;

public record FuncionarioResponseDTO (
    Long id,
    String cargo,
    PessoaResponseDTO pessoa
) {
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getCargo(),
            PessoaResponseDTO.valueOf(funcionario.getPessoa())
        );
    }
}