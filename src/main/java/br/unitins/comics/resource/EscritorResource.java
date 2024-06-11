package br.unitins.comics.resource;

import br.unitins.comics.dto.EscritorDTO;
import br.unitins.comics.service.EscritorService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
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
@Path("/escritores")
public class EscritorResource {

   @Inject
    public EscritorService escritorService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(escritorService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        return Response.ok(escritorService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(escritorService.findByNome(nome)).build();
    }

    @POST
    @RolesAllowed({"Funcionario"}) // Permite acesso apenas a funcionários
    public Response create(@Valid EscritorDTO dto) {
        return Response.status(Status.CREATED).entity(escritorService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"}) // Permite acesso apenas a funcionários
    public Response update(@PathParam("id") Long id, EscritorDTO dto) {
        escritorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"}) // Permite acesso apenas a funcionários
    public Response delete(@PathParam("id") Long id) {
        escritorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
