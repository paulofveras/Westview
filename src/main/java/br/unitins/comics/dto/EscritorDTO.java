package br.unitins.comics.dto;

import jakarta.validation.constraints.NotBlank;

public record EscritorDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio.")
    String nome,
    String cpf,
    String email
) { }
