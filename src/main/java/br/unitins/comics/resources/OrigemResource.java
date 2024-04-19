package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.OrigemDTO;
import br.unitins.comics.dto.OrigemResponseDTO;
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

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/origens")
public class OrigemResource {

    @Inject
    private OrigemService origemService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        OrigemResponseDTO origem = origemService.findById(id);
        if (origem != null) {
            return Response.ok(origem).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Origem não encontrada.")
                    .build();
        }
    }

    @GET
    public Response findAll() {
        List<OrigemResponseDTO> origens = origemService.findAll();
        return Response.ok(origens).build();
    }

    @POST
    public Response create(OrigemDTO dto) {
        origemService.create(dto);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, OrigemDTO dto) {
        origemService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        origemService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}