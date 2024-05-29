package br.unitins.comics.resources;

import br.unitins.comics.dto.AuthUsuarioDTO;
import br.unitins.comics.dto.PessoaResponseDTO;
import br.unitins.comics.service.ClienteService;
import br.unitins.comics.service.FuncionarioService;
import br.unitins.comics.service.hash.HashService;
import br.unitins.comics.service.jwt.JwtService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthUsuarioResource {

    @Inject
    public FuncionarioService funcionarioService;

    @Inject
    public ClienteService clienteService;

    @Inject
    public HashService hashService;

    @Inject
    public JwtService jwtService;

    @POST
    public Response login(AuthUsuarioDTO dto) {
        String hash = hashService.getHashSenha(dto.senha());

        PessoaResponseDTO usuario = null;
        // perfil 1 = funcionario
        if (dto.perfil() == 1) {
            usuario = funcionarioService.login(dto.username(), hash);
        } else if (dto.perfil() == 2) { // cliente
            usuario = clienteService.login(dto.username(), hash);
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(usuario)
            .header("Authorization", jwtService.generateJwt(dto, usuario))
            .build();
    }

}
