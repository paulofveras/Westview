package br.unitins.comics.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.comics.model.Classificacao;
import br.unitins.comics.model.Quadrinho;

public record QuadrinhoResponseDTO (
    Long id,
    String nome,
    LocalDate dataPublicacao,
    String edicao,
    Double preco,
    Integer quantidadeEstoque,
    CategoriaResponseDTO categoria,
    List<String> personagens,
    PessoaResponseDTO escritor,
    PessoaResponseDTO artistaCapa,
    Classificacao classificacao,
    GeneroResponseDTO genero,
    OrigemResponseDTO origem
) {
    public static QuadrinhoResponseDTO valueOf(Quadrinho quadrinho) {
        return new QuadrinhoResponseDTO(
            quadrinho.getId(),
            quadrinho.getNome(),
            quadrinho.getDataPublicacao(),
            quadrinho.getEdicao(),
            quadrinho.getPreco(),
            quadrinho.getQuantidadeEstoque(),
            CategoriaResponseDTO.valueOf(quadrinho.getCategoria()),
            quadrinho.getPersonagens(),
            PessoaResponseDTO.valueOf(quadrinho.getEscritor()),
            PessoaResponseDTO.valueOf(quadrinho.getArtistaCapa()),
            quadrinho.getClassificacao(),
            GeneroResponseDTO.valueOf(quadrinho.getGenero()),
            OrigemResponseDTO.valueOf(quadrinho.getOrigem())
        );
    }
}