package br.unitins.comics.service;

import br.unitins.comics.dto.CadastroBasicoDTO;
import br.unitins.comics.dto.CadastroBasicoResponseDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface CadastroBasicoService {
    public CadastroBasicoResponseDTO create(@Valid CadastroBasicoDTO dto);
    public UsuarioResponseDTO login(String username, String senha);
}
