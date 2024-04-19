package br.unitins.comics.dto;

import br.unitins.comics.model.ArtistaCapa;

public record ArtistaCapaResponseDTO (
    Long id,
    PessoaResponseDTO pessoa
) {
    public static ArtistaCapaResponseDTO valueOf(ArtistaCapa artistaCapa) {
        return new ArtistaCapaResponseDTO(
            artistaCapa.getId(),
            PessoaResponseDTO.valueOf(artistaCapa.getPessoa())
        );
    }
}
   

