package br.unitins.comics.dto;

import java.time.LocalDate;
import java.util.List;

public record QuadrinhoDTO (
    String nome,
    LocalDate dataPublicacao,
    String edicao,
    Double preco,
    Integer quantidadeEstoque,
    Long categoria,
    List<Long> escritores,
    List<Long> artistaCapa,
    Integer id_classificacao,
    Long genero,
    Long origem
) { }

