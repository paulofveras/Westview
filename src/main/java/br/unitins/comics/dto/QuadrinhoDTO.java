package br.unitins.comics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record QuadrinhoDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String nome, 
    @NotBlank(message = "A descrição não pode ser nula ou vazio")
    String descricao, 
    float preco, 
    Integer quantPaginas, 
    Integer id_material, 
    Long id_fornecedor,
    Integer estoque) { }
