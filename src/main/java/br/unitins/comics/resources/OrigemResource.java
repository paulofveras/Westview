package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.model.Origem;
import br.unitins.comics.service.OrigemService;
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

@Path("/origens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrigemResource {

    @Inject
    private OrigemService origemService;

    @GET
    public List<Origem> listarOrigens() {
        return origemService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarOrigem(@PathParam("id") Long id) {
        Origem origem = origemService.findById(id);
        if (origem != null) {
            return Response.ok(origem).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Origem não encontrada.")
                    .build();
        }
    }

    @POST
    public Response criarOrigem(Origem origem) {
        origemService.create(origem);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarOrigem(@PathParam("id") Long id, Origem origem) {
        Origem existingOrigem = origemService.findById(id);
        if (existingOrigem != null) {
            origem.setId(id);
            origemService.update(origem);
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Origem não encontrada.")
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirOrigem(@PathParam("id") Long id) {
        Origem origem = origemService.findById(id);
        if (origem != null) {
            origemService.delete(id);
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Origem não encontrada.")
                    .build();
        }
    }
}
