package br.unitins.comics.dto;

import br.unitins.comics.model.Escritor;

public record EscritorResponseDTO (
    Long id,
    PessoaResponseDTO pessoa
) {
    public static EscritorResponseDTO valueOf(Escritor escritor) {
        return new EscritorResponseDTO(
            escritor.getId(),
            PessoaResponseDTO.valueOf(escritor.getPessoa())
        );
    }
}


