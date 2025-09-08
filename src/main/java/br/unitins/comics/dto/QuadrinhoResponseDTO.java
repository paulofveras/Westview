package br.unitins.comics.dto;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.List;

import br.unitins.comics.model.Categoria;
import br.unitins.comics.model.Quadrinho;

public record QuadrinhoResponseDTO(
    Long id,
    String nome,
    LocalDate dataPublicacao,
    String edicao,
    String descricao,
    double preco,
    int quantidadeEstoque,
    Categoria categoria,
    List<String> personagens,
    PessoaDTO escritor,
    PessoaDTO artistaCapa
) {
    public static QuadrinhoResponseDTO valueOf(Quadrinho quadrinho) {
        return new QuadrinhoResponseDTO(
            quadrinho.getId(), 
            quadrinho.getNome(), 
            quadrinho.getDataPublicacao(), 
            quadrinho.getEdicao(), 
            quadrinho.getDescricao(), 
            quadrinho.getPreco(), 
            quadrinho.getQuantidadeEstoque(), 
            quadrinho.getCategoria(), 
            quadrinho.getPersonagens(), 
            PessoaDTO.valueOf(quadrinho.getEscritor()), 
            PessoaDTO.valueOf(quadrinho.getArtistaCapa())
        );
    }
}
=======

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
>>>>>>> ee80e95e1f4b3b188d07fdf23b8684f8dd807b6e
