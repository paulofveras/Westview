package br.unitins.comics.service.jwt;

import br.unitins.comics.dto.PessoaResponseDTO;

public interface JwtService {
    String generateJwt(PessoaResponseDTO dto, int perfil);
}
