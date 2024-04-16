package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.model.Categoria;
import br.unitins.comics.model.Quadrinho;
import br.unitins.comics.service.QuadrinhoService;
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

@Path("/quadrinhos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuadrinhoResource {

    private QuadrinhoService QuadrinhoService;

    public QuadrinhoResource(@Inject QuadrinhoService QuadrinhoService) {
        this.QuadrinhoService = QuadrinhoService;
    }

    @GET
    public List<Quadrinho> listarQuadrinhos() {
        return Quadrinho.findAllQuadrinhos();
    }

    @GET
    @Path("/{id}")
    public Response buscarQuadrinho(@PathParam("id") Long id) {
        Quadrinho Quadrinho = br.unitins.comics.model.Quadrinho.findById(id);
        if (Quadrinho != null) {
            return Response.ok(Quadrinho).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Quadrinho não encontrado.")
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirQuadrinho(@PathParam("id") Long id) {
        Quadrinho Quadrinho = br.unitins.comics.model.Quadrinho.findById(id);
        if (Quadrinho != null) {
            Quadrinho.excluir();
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Quadrinho não encontrado.")
                    .build();
        }
    }

    @POST
    public Response criarQuadrinho(QuadrinhoDTO QuadrinhoDTO) {
        try {
            QuadrinhoService.criarQuadrinho(QuadrinhoDTO);
            return Response.status(Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                   .entity("Erro ao criar o Quadrinho: " + e.getMessage())
                   .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizarQuadrinho(@PathParam("id") Long id, QuadrinhoDTO QuadrinhoDTO) {
        try {
            QuadrinhoService.atualizarQuadrinho(id, QuadrinhoDTO);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                   .entity("Erro ao atualizar o Quadrinho: " + e.getMessage())
                   .build();
        }
    }
}


