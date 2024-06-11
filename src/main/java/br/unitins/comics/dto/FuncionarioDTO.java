package br.unitins.comics.dto;

import java.time.LocalDate;


public record FuncionarioDTO (
    Double salario,
    String cargo,
    String nome,
    String username,
    LocalDate dataNascimento,
    String email,
    String senha,
    String cpf,
    String genero
) { }
