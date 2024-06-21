package br.unitins.comics.resource;


import org.jboss.logging.Logger;

import br.unitins.comics.dto.ClienteDTO;
import br.unitins.comics.dto.UpdatePasswordDTO;
import br.unitins.comics.dto.UpdateUsernameDTO;
import br.unitins.comics.service.ClienteService;
import jakarta.annotation.security.RolesAllowed;
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
@Path("/clientes")
public class ClienteResource {
    
    @Inject
    public ClienteService clienteService;

    private static final Logger LOG = Logger.getLogger(EnderecoResource.class);

    @GET
    @RolesAllowed("Funcionario")
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(clienteService.findById(id)).build();
    }

    @GET
    @RolesAllowed("Funcionario")
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(clienteService.findAll()).build();
    }

    @GET
    @RolesAllowed("Funcionario")
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.info("Executando o metodo findBynome");
        return Response.ok(clienteService.findByNome(nome)).build();
    }

    @POST
    @RolesAllowed({"Funcionario","Cliente"})
    public Response create(@Valid ClienteDTO dto) {
        LOG.info("Criando um novo cliente");
        return Response.status(Status.CREATED).entity(clienteService.create(dto)).build();
    }

    @PUT
    @RolesAllowed({"Funcionario","Cliente"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        LOG.debugf("DTO Atualizado: %s", dto);
        clienteService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @RolesAllowed("Cliente")
    @Path("/update-password/{id}")
    public Response updateUsuarioSenha(@PathParam("id") Long id, UpdatePasswordDTO dto){
        LOG.info("Atualizando senha");
        clienteService.updatePassword(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @RolesAllowed("Cliente")
    @Path("/update-username/{id}")
    public Response updateUsuarioUsername(@PathParam("id") Long id, UpdateUsernameDTO dto){
        LOG.info("Atualizando username");
        clienteService.updateUsername(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @RolesAllowed("Funcionario")
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando cliente. Id: %s", id.toString());
        clienteService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
