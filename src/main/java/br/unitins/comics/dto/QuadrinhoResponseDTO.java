package br.unitins.comics.dto;

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