package br.unitins.comics.dto;

import br.unitins.comics.model.Cliente;

public record ClienteResponseDTO (
    Long id,
    PessoaResponseDTO pessoa
) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO(
            cliente.getId(),
            PessoaResponseDTO.fromPessoa(cliente.getPessoa())
        );
    }
}
