package br.unitins.comics.dto;

import br.unitins.comics.model.Categoria;

public record CategoriaResponseDTO (
    Long id,
    String universo
) {
    public static CategoriaResponseDTO valueOf(Categoria categoria) {
        return new CategoriaResponseDTO(
            categoria.getId(),
            categoria.getUniverso()
        );
    }
}