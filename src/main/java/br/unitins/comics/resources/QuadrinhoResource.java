package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;
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

@Path("/quadrinhos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuadrinhoResource {

    @Inject
    private QuadrinhoService quadrinhoService;

    @GET
    public Response findAll() {
        List<QuadrinhoResponseDTO> quadrinhos = quadrinhoService.findAll();
        return Response.ok(quadrinhos).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        QuadrinhoResponseDTO quadrinho = quadrinhoService.findById(id);
        if (quadrinho != null) {
            return Response.ok(quadrinho).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Quadrinho não encontrado.")
                    .build();
        }
    }

    @POST
    public Response create(QuadrinhoDTO dto) {
        QuadrinhoResponseDTO created = quadrinhoService.create(dto);
        return Response.status(Status.CREATED).entity(created).build();
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
