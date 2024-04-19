package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.CategoriaDTO;
import br.unitins.comics.dto.CategoriaResponseDTO;
import br.unitins.comics.service.CategoriaService;
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
@Path("/categorias")
public class CategoriaResource {

    @Inject
    private CategoriaService categoriaService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        CategoriaResponseDTO categoria = categoriaService.findById(id);
        if (categoria != null) {
            return Response.ok(categoria).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Categoria não encontrada.")
                    .build();
        }
    }

    @GET
    public Response findAll() {
        List<CategoriaResponseDTO> categorias = categoriaService.findAll();
        return Response.ok(categorias).build();
    }

    @POST
    public Response create(CategoriaDTO dto) {
        categoriaService.create(dto);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CategoriaDTO dto) {
        categoriaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        categoriaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}