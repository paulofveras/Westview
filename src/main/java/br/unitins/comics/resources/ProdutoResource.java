package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.ProdutoDTO;
import br.unitins.comics.model.Produto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    
    @GET
    public List<Produto> listarProdutos() {
        return Produto.findAllProdutos();
    }

    @GET
    @Path("/{id}")
    public Produto buscarProduto(@PathParam("id") Long id) {
        return Produto.findById(id);
    }

    @POST
    @Path("/{id}")
    public void atualizarProduto(@PathParam("id") Long id, ProdutoDTO produtoDTO) {
        Produto produto = Produto.findById(id);
        if (produto != null) {
            produto.setNome(produtoDTO.getNome());
            produto.setDataPublicacao(produtoDTO.getDataPublicacao());
            produto.setEdicao(produtoDTO.getEdicao());
            produto.setEscritor(produtoDTO.getEscritor());
            produto.setArtistaCapa(produtoDTO.getArtistaCapa());
            produto.setDescricao(produtoDTO.getDescricao());
            produto.setPreco(produtoDTO.getPreco());
            produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
            produto.alterar();
        }
    }
    

    @DELETE
    @Path("/{id}")
    public void excluirProduto(@PathParam("id") Long id) {
        Produto entity = Produto.findById(id);
        if (entity != null) {
            entity.excluir();
        }
    }
}


