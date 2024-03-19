package br.unitins.comics.service;

import br.unitins.comics.dto.ProdutoDTO;
import br.unitins.comics.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class ProdutoService {
    


    @Transactional
    public Response criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        preencherProduto(produto, produtoDTO);
        produto.persist();
        return Response.status(Status.ACCEPTED)
        .entity("Sucesso.")
        .build();
    }

    @Transactional
    public void atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produto = Produto.findById(id);
        if (produto != null) {
            preencherProduto(produto, produtoDTO);
            produto.persist();
        }
    }

    @Transactional
    public void excluirProduto(Long id) {
        Produto produto = Produto.findById(id);
        if (produto != null) {
            produto.delete();
        }
    }

    private void preencherProduto(Produto produto, ProdutoDTO produtoDTO) {
        produto.setNome(produtoDTO.getNome());
        produto.setDataPublicacao(produtoDTO.getDataPublicacao());
        produto.setEdicao(produtoDTO.getEdicao());
        produto.setEscritor(produtoDTO.getEscritor());
        produto.setArtistaCapa(produtoDTO.getArtistaCapa());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
        produto.setEditora(produtoDTO.getEditora());
    }
}
