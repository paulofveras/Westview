package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.ProdutoDTO;
import br.unitins.comics.model.Categoria;
import br.unitins.comics.model.Produto;
import br.unitins.comics.service.ProdutoService;
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

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    private ProdutoService produtoService;
    
    @GET
    public List<Produto> listarProdutos() {
        return Produto.findAllProdutos();
    }

    @GET
    @Path("/{id}")
    public Produto buscarProduto(@PathParam("id") Long id) {
        return Produto.findById(id);
    }

    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @DELETE
    @Path("/{id}")
    public void excluirProduto(@PathParam("id") Long id) {
        Produto entity = Produto.findById(id);
        if (entity != null) {
            entity.excluir();
        }
    }
    @POST
    @Path("/")
    public Response criarProduto(ProdutoDTO produtoDTO) {
        
        if (produtoService != null) {
            return produtoService.criarProduto(produtoDTO);
        } else {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                   .entity("O serviço de produto não está disponível no momento.")
                   .build();
        }
    }


    @PUT
    @Path("/{id}")
    public Response atualizarProduto(@PathParam("id") Long id, @Valid ProdutoDTO produtoDTO) {
        produtoService.atualizarProduto(id, produtoDTO);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
}


