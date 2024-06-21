package br.unitins.comics.dto;

import br.unitins.comics.model.Endereco;

public record EnderecoResponseDTO (
    Long id,
    Integer cep,
    String rua, 
    Integer numero) { 
    public static EnderecoResponseDTO valueOf(Endereco endereco) {
    return new  EnderecoResponseDTO(
        endereco.getId(),
        endereco.getCep(),
        endereco.getRua(),
        endereco.getNumero());
    }
}
