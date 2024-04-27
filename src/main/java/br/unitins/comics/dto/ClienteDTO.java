package br.unitins.comics.dto;

public record ClienteDTO (
    String estado,
    String cidade,
    String nome,
    String cpf,
    String email
) { }
