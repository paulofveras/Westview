package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.model.Categoria;
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

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    private CategoriaService categoriaService;

    @GET
    public List<Categoria> listarCategorias() {
        return categoriaService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarCategoria(@PathParam("id") Long id) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria != null) {
            return Response.ok(categoria).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Categoria não encontrada.")
                    .build();
        }
    }

    @POST
    public Response criarCategoria(Categoria categoria) {
        categoriaService.create(categoria);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarCategoria(@PathParam("id") Long id, Categoria categoria) {
        Categoria existingCategoria = categoriaService.findById(id);
        if (existingCategoria != null) {
            categoria.setId(id);
            categoriaService.update(categoria);
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Categoria não encontrada.")
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirCategoria(@PathParam("id") Long id) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria != null) {
            categoriaService.delete(id);
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Categoria não encontrada.")
                    .build();
        }
    }
}
