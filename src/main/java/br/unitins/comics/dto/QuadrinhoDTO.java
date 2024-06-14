package br.unitins.comics.dto;

import java.time.LocalDate;

public record QuadrinhoDTO (
    String nome,
    LocalDate dataPublicacao,
    String edicao,
    Double preco,
    Integer quantidadePaginas,
    Long categoria,
    Long escritorId,
    Long artistaCapaId,
    Integer id_classificacao,
    Long generoId,
    Long origemId,
    Integer estoque
) { }

