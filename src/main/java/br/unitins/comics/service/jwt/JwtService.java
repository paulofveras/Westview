package br.unitins.comics.service.jwt;

import br.unitins.comics.dto.AuthUsuarioDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;

public interface JwtService {
    String generateJwt(AuthUsuarioDTO authDTO, UsuarioResponseDTO dto);
}
