package br.unitins.comics.dto;

import java.util.List;

import br.unitins.comics.model.Pessoa;

public record PessoaResponseDTO (
    Long id,
    String nome,
    String cpf,
    String email,
    List<FuncionarioResponseDTO> funcionarios,
    List<ClienteResponseDTO> clientes,
    List<EscritorResponseDTO> escritores,
    List<ArtistaCapaResponseDTO> artistasCapa
) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa) {
        return new PessoaResponseDTO(
            pessoa.getId(),
            pessoa.getNome(),
            pessoa.getCpf(),
            pessoa.getEmail(),
            pessoa.getFuncionarios().stream()
                .map(FuncionarioResponseDTO::valueOf)
                .toList(),
            pessoa.getClientes().stream()
                .map(ClienteResponseDTO::valueOf)
                .toList(),
            pessoa.getEscritores().stream()
                .map(EscritorResponseDTO::valueOf)
                .toList(),
            pessoa.getArtistasCapa().stream()
                .map(ArtistaCapaResponseDTO::valueOf)
                .toList()
        );
    }
}