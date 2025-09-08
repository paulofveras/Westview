package br.unitins.comics.dto;

import br.unitins.comics.model.Fornecedor;

public record FornecedorResponseDTO (
    Long id,
    String nome, 
    EnderecoResponseDTO endereco, 
    TelefoneResponseDTO telefone, 
    String email) { 
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor) {
    return new  FornecedorResponseDTO(
    fornecedor.getId(),    
    fornecedor.getNome(),
    EnderecoResponseDTO.valueOf(fornecedor.getEndereco()),
    TelefoneResponseDTO.valueOf(fornecedor.getTelefone()),
        fornecedor.getEmail());
    }
}
