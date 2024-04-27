package br.unitins.comics.dto;

import br.unitins.comics.model.Cliente;

public record ClienteResponseDTO (
    Long id,
    String estado,
    String cidade,
    PessoaResponseDTO pessoa
) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getEstado(),
            cliente.getCidade(),
            PessoaResponseDTO.valueOf(cliente.getPessoa())
        );
    }
}
