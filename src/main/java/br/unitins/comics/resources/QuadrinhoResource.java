package br.unitins.comics.resources;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.service.QuadrinhoService;
import jakarta.inject.Inject;
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
@Path("/quadrinhos")
public class QuadrinhoResource {
    
    @Inject
    public QuadrinhoService quadrinhoService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(quadrinhoService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(quadrinhoService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(quadrinhoService.findByNome(nome)).build();
    }

    @POST
    public Response create(QuadrinhoDTO dto) {
        return Response.status(Status.CREATED).entity(quadrinhoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, QuadrinhoDTO dto) {
        quadrinhoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        quadrinhoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}

