package br.unitins.comics.dto;

import java.util.List;

public record PessoaDTO (
    Long id,
    String nome,
    String cpf,
    String email,
    List<FuncionarioDTO> funcionarios,
    List<ClienteDTO> clientes,
    List<EscritorDTO> escritores,
    List<ArtistaCapaDTO> artistasCapa
) { }
