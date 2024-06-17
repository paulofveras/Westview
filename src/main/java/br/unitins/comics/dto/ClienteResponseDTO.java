package br.unitins.comics.dto;

import br.unitins.comics.model.Cliente;

public record ClienteResponseDTO
    (Long id, 
    String nome, 
    EnderecoResponseDTO endereco, 
    TelefoneResponseDTO telefone,
    String email,
    UsuarioResponseDTO usuario) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO( 
            cliente.getId(),
            cliente.getNome(),
            EnderecoResponseDTO.valueOf(cliente.getEndereco()),
            TelefoneResponseDTO.valueOf(cliente.getTelefone()),
            cliente.getEmail(),
            cliente.getUsuario() != null ? UsuarioResponseDTO.valueOf(cliente) : null);
    }
    
}
