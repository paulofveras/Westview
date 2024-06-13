package br.unitins.comics.resource;

import org.jboss.logging.Logger;

import br.unitins.comics.dto.FuncionarioDTO;
import br.unitins.comics.dto.UpdatePasswordDTO;
import br.unitins.comics.dto.UpdateUsernameDTO;
import br.unitins.comics.service.FuncionarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/funcionarios")
public class FuncionarioResource {

    @Inject
    public FuncionarioService funcionarioService;

    private static final Logger LOG = Logger.getLogger(QuadrinhoResource.class);

    @GET
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(funcionarioService.findAll()).build();
    }


    @GET
    @Path("/search/cargo/{cargo}")
    public Response findByCargo(@PathParam("cargo") String cargo) {
        LOG.info("Executando o findByCargo");
        return Response.ok(funcionarioService.findByCargo(cargo)).build();
    }

    @GET
    @Path("/search/cpf/{cpf}")
    public Response findByCpf(@PathParam("cpf") String cpf) {
        LOG.info("Executando o findbyCPF");
        return Response.ok(funcionarioService.findByCpf(cpf)).build();
    }

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(funcionarioService.findById(id)).build();
    }


    @POST
    public Response create(@Valid FuncionarioDTO dto) {
        LOG.info("Criando um novo funcionario");
        try {
            LOG.infof("Funcionario criado com sucesso. Nome: %d", dto.nome());
            return Response.status(Status.CREATED).entity(funcionarioService.create(dto)).build();
         }  catch (Exception e) {
        LOG.error("Erro ao criar funcionario", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
     }

    @PUT
    @Path("/{id}")
     public Response update(@PathParam("id") Long id, FuncionarioDTO dto) {
         LOG.debugf("DTO Atualizado: %s", dto);
         funcionarioService.update(id, dto);
         return Response.status(Status.NO_CONTENT).build();
     }
     
    @PATCH
    @Path("/update-password/{id}")
    public Response updateUsuarioSenha(@PathParam("id") Long id, UpdatePasswordDTO dto){
        LOG.info("Atualizando senha");
        funcionarioService.updatePassword(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/update-username/{id}")
    public Response updateUsuarioUsername(@PathParam("id") Long id, UpdateUsernameDTO dto){
        LOG.info("Atualizando username");
        funcionarioService.updateUsername(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando funcionário. Id: %s", id.toString());
        funcionarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
