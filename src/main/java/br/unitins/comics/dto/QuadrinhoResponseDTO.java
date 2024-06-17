package br.unitins.comics.dto;


import br.unitins.comics.model.Quadrinho;
import br.unitins.comics.model.Material;
public record QuadrinhoResponseDTO
    (Long id,
    String nome, 
    String descricao, 
    float preco,  
    Integer quantPaginas, 
    Material material, 
    FornecedorResponseDTO fornecedor,
    String nomeImagem,
    Integer estoque){
    public static QuadrinhoResponseDTO valueOf(Quadrinho quadrinho) {
        return new  QuadrinhoResponseDTO(
            quadrinho.getId(),
            quadrinho.getNome(),
            quadrinho.getDescricao(),
            quadrinho.getPreco(),
            quadrinho.getQuantPaginas(),
            quadrinho.getMaterial(),
            FornecedorResponseDTO.valueOf(quadrinho.getFornecedor()),
            quadrinho.getNomeImagem(),
            quadrinho.getEstoque()
            );
        }
    
}
