package br.unitins.comics.dto;

import java.time.LocalDate;

import br.unitins.comics.model.Cliente;
import br.unitins.comics.model.Funcionario;
import br.unitins.comics.model.Usuario;

public record UsuarioResponseDTO (
    Long id,
    String nome,
    String username,
    String senha,
    LocalDate dataNascimento,
    String email,
    String genero,
    String cpf
){
    
    public static UsuarioResponseDTO valueof(Usuario c){
        return new UsuarioResponseDTO(
            c.getId(),
            c.getNome(),
            c.getUsername(),
            c.getSenha(),
            c.getDataNascimento(),
            c.getEmail(),
            c.getGenero(),
            c.getCpf()
        );
    }

    public static UsuarioResponseDTO valueOf(Funcionario func) {
        return new UsuarioResponseDTO(
                func.getUsuario().getId(),
                func.getUsuario().getNome(),
                func.getUsuario().getUsername(),
                func.getUsuario().getSenha(),
                func.getUsuario().getDataNascimento(),
                func.getUsuario().getEmail(),
                func.getUsuario().getGenero(),
                func.getUsuario().getCpf()
            );
    }
    public static UsuarioResponseDTO valueOf(Cliente cli) {
        return new UsuarioResponseDTO(
                cli.getUsuario().getId(),
                cli.getUsuario().getNome(),
                cli.getUsuario().getUsername(),
                cli.getUsuario().getSenha(),
                cli.getUsuario().getDataNascimento(),
                cli.getUsuario().getEmail(),
                cli.getUsuario().getGenero(),
                cli.getUsuario().getCpf()
            );
    }

}
