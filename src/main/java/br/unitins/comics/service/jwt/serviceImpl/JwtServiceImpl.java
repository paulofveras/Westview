package br.unitins.comics.service.jwt.serviceImpl;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import br.unitins.comics.dto.AuthUsuarioDTO;
import br.unitins.comics.dto.PessoaResponseDTO;
import br.unitins.comics.service.jwt.JwtService;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwt(AuthUsuarioDTO authDTO, PessoaResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
    
        if(authDTO.perfil() == 1){
            roles.add("Funcionario");
        }else if (authDTO.perfil() == 2){
            roles.add("Cliente");
        }
      
        return Jwt.issuer("unitins-jwt")
            .subject(dto.username())
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();
    }
    
}