package br.unitins.comics.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO (
    Integer cep,
    @NotBlank(message = "A rua não pode ser nulo ou vazio")
    String rua, 
    Integer numero) { }
