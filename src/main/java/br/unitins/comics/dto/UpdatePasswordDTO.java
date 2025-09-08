package br.unitins.comics.dto;

public record UpdatePasswordDTO(
    String oldPassword,
    String newPassword
) {
    
}
