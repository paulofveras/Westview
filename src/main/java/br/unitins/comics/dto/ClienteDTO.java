package br.unitins.comics.dto;

import java.time.LocalDate;

public record ClienteDTO (
    String cep,
    String endereco,
    String estado,
    String cidade, 
    String nome,
    String username,
    LocalDate dataNascimento,
    String email,
    String senha,
    String cpf,
    String genero
) { }
