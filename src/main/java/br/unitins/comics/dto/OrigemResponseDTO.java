package br.unitins.comics.dto;

import br.unitins.comics.model.Origem;

public record OrigemResponseDTO (
    Long id,
    String pais
) {
    public static OrigemResponseDTO valueOf(Origem origem) {
        return new OrigemResponseDTO(
            origem.getId(),
            origem.getPais()
        );
    }
}