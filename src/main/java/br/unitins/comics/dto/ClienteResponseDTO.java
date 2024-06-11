package br.unitins.comics.dto;

import br.unitins.comics.model.Cliente;

public record ClienteResponseDTO (
    Long id,
    String cep,
    String endereco,
    String estado,
    String cidade, 
    UsuarioResponseDTO usuario
) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getCep(),
            cliente.getEndereco(),
            cliente.getEstado(),
            cliente.getCidade(),
            UsuarioResponseDTO.valueof(cliente.getUsuario())
        );
    }
}
