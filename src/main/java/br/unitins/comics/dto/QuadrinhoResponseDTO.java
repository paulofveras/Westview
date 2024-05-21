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
    List<EscritorResponseDTO> escritor,
    List<ArtistaCapaResponseDTO> artistaCapa,
    Classificacao id_classificacao,
    GeneroResponseDTO genero,
    OrigemResponseDTO origem
) {
    public static QuadrinhoResponseDTO valueOf(Quadrinho quadrinho) {

        List<EscritorResponseDTO> listaEscritor = quadrinho.getListaEscritor()
                .stream()
                .map(EscritorResponseDTO::valueOf)
                .toList();

        List<ArtistaCapaResponseDTO> listaArtistaCapa = quadrinho.getListaArtistaCapa()
                .stream()
                .map(ArtistaCapaResponseDTO::valueOf)
                .toList();

        return new QuadrinhoResponseDTO(
            quadrinho.getId(),
            quadrinho.getNome(),
            quadrinho.getDataPublicacao(),
            quadrinho.getEdicao(),
            quadrinho.getPreco(),
            quadrinho.getQuantidadeEstoque(),
            CategoriaResponseDTO.valueOf(quadrinho.getCategoria()),
            listaEscritor,
            listaArtistaCapa,
            quadrinho.getClassificacao(),
            GeneroResponseDTO.valueOf(quadrinho.getGenero()),
            OrigemResponseDTO.valueOf(quadrinho.getOrigem())
        );
    }
}