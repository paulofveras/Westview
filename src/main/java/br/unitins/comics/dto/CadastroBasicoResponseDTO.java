package br.unitins.comics.dto;

import br.unitins.comics.model.Cliente;

public record CadastroBasicoResponseDTO(
        Long idCliente,
        String nome,
        TelefoneResponseDTO telefone,
        EnderecoResponseDTO endereco,
        String email,
        String username
) {

    public static CadastroBasicoResponseDTO valueOf(Cliente cliente) {
        return new CadastroBasicoResponseDTO(
            cliente.getUsuario().getId(), 
            cliente.getNome(),
            TelefoneResponseDTO.valueOf(cliente.getTelefone()),
            EnderecoResponseDTO.valueOf(cliente.getEndereco()),
            cliente.getEmail(),
            cliente.getUsuario().getUsername()
        );
    }
}
