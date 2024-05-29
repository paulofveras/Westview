package br.unitins.comics.dto;

import java.time.LocalDate;

public record QuadrinhoDTO (
    String nome,
    LocalDate dataPublicacao,
    String edicao,
    Double preco,
    Integer quantidadeEstoque,
    Long categoria,
    Long escritorId,
    Long artistaCapaId,
    Integer id_classificacao,
    Long genero,
    Long origem
) { }

