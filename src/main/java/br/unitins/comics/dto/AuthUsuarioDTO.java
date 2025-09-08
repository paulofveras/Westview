package br.unitins.comics.dto;

public record AuthUsuarioDTO(
    String username,
    String senha,
    int perfil
) {

}