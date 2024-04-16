package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.model.Genero;
import br.unitins.comics.service.GeneroService;
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

@Path("/generos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GeneroResource {

    @Inject
    private GeneroService generoService;

    @GET
    public List<Genero> listarGeneros() {
        return generoService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarGenero(@PathParam("id") Long id) {
        Genero genero = generoService.findById(id);
        if (genero != null) {
            return Response.ok(genero).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Gênero não encontrado.")
                    .build();
        }
    }

    @POST
    public Response criarGenero(Genero genero) {
        generoService.create(genero);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarGenero(@PathParam("id") Long id, Genero genero) {
        Genero existingGenero = generoService.findById(id);
        if (existingGenero != null) {
            genero.setId(id);
            generoService.update(genero);
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Gênero não encontrado.")
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirGenero(@PathParam("id") Long id) {
        Genero genero = generoService.findById(id);
        if (genero != null) {
            generoService.delete(id);
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Gênero não encontrado.")
                    .build();
        }
    }
}