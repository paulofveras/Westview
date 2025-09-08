package br.unitins.comics.dto;

import br.unitins.comics.model.Funcionario;

public record FuncionarioResponseDTO (
    Long id,
    String nome,
    String cargo, 
    EnderecoResponseDTO endereco, 
    TelefoneResponseDTO telefone, 
    String email,
    String senha,
    UsuarioResponseDTO usuario) { 
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
    return new FuncionarioResponseDTO(
        funcionario.getId(),
        funcionario.getNome(),
        funcionario.getCargo(),
        EnderecoResponseDTO.valueOf(funcionario.getEndereco()),
        TelefoneResponseDTO.valueOf(funcionario.getTelefone()),
        funcionario.getEmail(),
        funcionario.getUsuario().getSenha(),
        UsuarioResponseDTO.valueOf(funcionario));
    }
}
