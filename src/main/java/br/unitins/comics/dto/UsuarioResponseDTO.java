package br.unitins.comics.dto;

import java.time.LocalDateTime;

import br.unitins.comics.model.Pessoa;

public record UsuarioResponseDTO (
    Long id,
    String username,
    String nome,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao
){
    
    public static UsuarioResponseDTO valueof(Pessoa pf){
        return new UsuarioResponseDTO(
            pf.getId(),
            pf.getUsuario().getUsername(),
            pf.getNome(),
            pf.getDataCadastro(),
            pf.getDataAlteracao()
        );
    }

}
