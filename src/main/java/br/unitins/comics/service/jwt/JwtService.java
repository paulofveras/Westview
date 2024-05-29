package br.unitins.comics.service.jwt;

import br.unitins.comics.dto.AuthUsuarioDTO;
import br.unitins.comics.dto.PessoaResponseDTO;

public interface JwtService {
    String generateJwt(AuthUsuarioDTO authDTO, PessoaResponseDTO dto);
}
