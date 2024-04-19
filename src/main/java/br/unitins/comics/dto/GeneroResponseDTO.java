package br.unitins.comics.dto;

import br.unitins.comics.model.Genero;

public record GeneroResponseDTO (
    Long id,
    String genero,
    String descricao
) {
    public static GeneroResponseDTO valueOf(Genero genero) {
        return new GeneroResponseDTO(
            genero.getId(),
            genero.getGenero(),
            genero.getDescricao()
        );
    }
}