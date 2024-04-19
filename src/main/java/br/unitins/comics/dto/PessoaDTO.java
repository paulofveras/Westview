package br.unitins.comics.dto;

public record PessoaDTO (
    Long id,
    String nome,
    String cpf,
    String email
) { }
