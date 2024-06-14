package br.unitins.comics.dto;

import java.time.LocalDate;

import br.unitins.comics.model.Quadrinho;

public record QuadrinhoResponseDTO (
    Long id,
    String nome,
    LocalDate dataPublicacao,
    String edicao,
    Double preco,
    Integer quantidadePaginas,
    Long categoriaId,
    Long escritorId,
    Long artistaCapaId,
    Integer classificacaoId,
    Long generoId,
    Long origemId,
    String nomeImagem,
    Integer estoque
) {
    public static QuadrinhoResponseDTO valueOf(Quadrinho quadrinho) {
        return new QuadrinhoResponseDTO(
            quadrinho.getId(),
            quadrinho.getNome(),
            quadrinho.getDataPublicacao(),
            quadrinho.getEdicao(),
            quadrinho.getPreco(),
            quadrinho.getQuantidadePaginas(),
            quadrinho.getCategoria().getId(),
            quadrinho.getEscritor().getId(),
            quadrinho.getArtistaCapa().getId(),
            quadrinho.getClassificacao().getId(),
            quadrinho.getGenero().getId(),
            quadrinho.getOrigem().getId(),
            quadrinho.getNomeImagem(),
            quadrinho.getEstoque()
        );
    }
}