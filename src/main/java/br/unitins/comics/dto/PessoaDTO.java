package br.unitins.comics.dto;

public record PessoaDTO (
    String nome,
    String cpf,
    String email,
    String username,
    String password
) { }
