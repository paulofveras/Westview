package br.unitins.comics.dto;

import br.unitins.comics.model.Telefone;

public record TelefoneResponseDTO(
    Long id,
    String codigoArea,
    String numero
) {
    public static TelefoneResponseDTO valueOf(Telefone telefone) {
        return new TelefoneResponseDTO(
            telefone.getId(),
            telefone.getCodigoArea(), 
            telefone.getNumero());
    }
    
}
