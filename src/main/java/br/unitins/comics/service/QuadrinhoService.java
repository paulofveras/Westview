package br.unitins.comics.service;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.model.Categoria;
import br.unitins.comics.model.Quadrinho;
import br.unitins.comics.repository.CategoriaRepository;
import br.unitins.comics.repository.QuadrinhoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class QuadrinhoService {

    @Inject
    private QuadrinhoRepository quadrinhoRepository;

    @Inject
    private CategoriaRepository categoriaRepository;

    @Transactional
    public void criarQuadrinho(QuadrinhoDTO quadrinhoDTO) {
        Quadrinho quadrinho = new Quadrinho();
        preencherQuadrinho(quadrinho, quadrinhoDTO);
        quadrinhoRepository.persist(quadrinho);
    }

    @Transactional
    public void atualizarQuadrinho(Long id, QuadrinhoDTO quadrinhoDTO) {
        Quadrinho quadrinho = quadrinhoRepository.findById(id);
        if (quadrinho != null) {
            preencherQuadrinho(quadrinho, quadrinhoDTO);
            quadrinhoRepository.persist(quadrinho);
        }
    }

    @Transactional
    public void excluirQuadrinho(Long id) {
        Quadrinho quadrinho = quadrinhoRepository.findById(id);
        if (quadrinho != null) {
            quadrinhoRepository.delete(quadrinho);
        }
    }

    private void preencherQuadrinho(Quadrinho quadrinho, QuadrinhoDTO quadrinhoDTO) {
        quadrinho.setNome(quadrinhoDTO.getNome());
        quadrinho.setDataPublicacao(quadrinhoDTO.getDataPublicacao());
        quadrinho.setEdicao(quadrinhoDTO.getEdicao());
        quadrinho.setEscritor(quadrinhoDTO.getEscritor());
        quadrinho.setArtistaCapa(quadrinhoDTO.getArtistaCapa());
        quadrinho.setDescricao(quadrinhoDTO.getDescricao());
        quadrinho.setPreco(quadrinhoDTO.getPreco());
        quadrinho.setQuantidadeEstoque(quadrinhoDTO.getQuantidadeEstoque());
        Categoria categoria = categoriaRepository.findById(quadrinhoDTO.getCategoriaId());
        quadrinho.setCategoria(categoria);
    }
}
