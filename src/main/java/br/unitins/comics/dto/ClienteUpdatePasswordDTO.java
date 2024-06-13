package br.unitins.comics.dto;

public record ClienteUpdatePasswordDTO(
    String oldPassword,
    String newPassword
) {

}
