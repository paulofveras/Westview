package br.unitins.comics.service.jwt;

import br.unitins.comics.dto.AuthUsuarioDTO;

public interface JwtService {
    String generateJwt(AuthUsuarioDTO authDTO);
}
