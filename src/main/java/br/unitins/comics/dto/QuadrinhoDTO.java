package br.unitins.comics.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.comics.model.Classificacao;

public record QuadrinhoDTO (
    Long id,
    String nome,
    LocalDate dataPublicacao,
    String edicao,
    Double preco,
    Integer quantidadeEstoque,
    CategoriaDTO categoria,
    List<String> personagens,
    PessoaDTO escritor,
    PessoaDTO artistaCapa,
    Classificacao classificacao,
    GeneroDTO genero,
    OrigemDTO origem
) { }

