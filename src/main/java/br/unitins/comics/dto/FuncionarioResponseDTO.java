package br.unitins.comics.dto;

import br.unitins.comics.model.Funcionario;

public record FuncionarioResponseDTO (
    Long id,
    Double salario,
    String cargo,
    UsuarioResponseDTO usuario
) {
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getSalario(),
            funcionario.getCargo(),
            UsuarioResponseDTO.valueof(funcionario.getUsuario())
        );
    }
}