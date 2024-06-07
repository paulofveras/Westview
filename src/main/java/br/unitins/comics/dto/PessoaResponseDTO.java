package br.unitins.comics.dto;

import br.unitins.comics.model.Pessoa;

public record PessoaResponseDTO (
    Long id,
    String nome,
    String cpf,
    String email,
    String username,
    String password
) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa) {
        return new PessoaResponseDTO(
            pessoa.getId(),
            pessoa.getNome(),
            pessoa.getCpf(),
            pessoa.getEmail(),
            pessoa.getUsuario().getUsername(),
            pessoa.getUsuario().getPassword()
        );
    }
}