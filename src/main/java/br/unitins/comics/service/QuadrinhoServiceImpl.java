package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;
import br.unitins.comics.model.Categoria;
import br.unitins.comics.model.Classificacao;
import br.unitins.comics.model.Genero;
import br.unitins.comics.model.Origem;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.model.Quadrinho;
import br.unitins.comics.repository.CategoriaRepository;
import br.unitins.comics.repository.GeneroRepository;
import br.unitins.comics.repository.OrigemRepository;
import br.unitins.comics.repository.PessoaRepository;
import br.unitins.comics.repository.QuadrinhoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class QuadrinhoServiceImpl implements QuadrinhoService {

    @Inject
    private QuadrinhoRepository quadrinhoRepository;

    @Inject
    private CategoriaRepository categoriaRepository;

    @Inject
    private GeneroRepository generoRepository;

    @Inject
    private OrigemRepository origemRepository;

    @Inject PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public QuadrinhoResponseDTO create(QuadrinhoDTO dto) {
        Quadrinho quadrinho = new Quadrinho();
        preencherQuadrinho(quadrinho, dto);
        quadrinhoRepository.persist(quadrinho);
        return QuadrinhoResponseDTO.valueOf(quadrinho);
    }

    @Override
    @Transactional
    public void update(Long id, QuadrinhoDTO dto) {
        Quadrinho quadrinho = quadrinhoRepository.findById(id);
        if (quadrinho != null) {
            preencherQuadrinho(quadrinho, dto);
            quadrinhoRepository.persist(quadrinho);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Quadrinho quadrinho = quadrinhoRepository.findById(id);
        if (quadrinho != null) {
            quadrinhoRepository.delete(quadrinho);
        }
    }

    @Override
    public QuadrinhoResponseDTO findById(Long id) {
        Quadrinho quadrinho = quadrinhoRepository.findById(id);
        return QuadrinhoResponseDTO.valueOf(quadrinho);
    }

    @Override
    public List<QuadrinhoResponseDTO> findAll() {
        return quadrinhoRepository.listAll()
                .stream()
                .map(QuadrinhoResponseDTO::valueOf)
                .toList();
    }

    private void preencherQuadrinho(Quadrinho quadrinho, QuadrinhoDTO dto) {
        quadrinho.setNome(dto.nome());
        quadrinho.setDataPublicacao(dto.dataPublicacao());
        quadrinho.setEdicao(dto.edicao());
        quadrinho.setPreco(dto.preco());
        quadrinho.setQuantidadeEstoque(dto.quantidadeEstoque());
        quadrinho.setClassificacao(Classificacao.valueOf(dto.classificacao().getId()));
        // Preenchendo a categoria do quadrinho
        Categoria categoria = categoriaRepository.findById(dto.categoria().id());
        quadrinho.setCategoria(categoria);
    
        // Preenchendo o genero do quadrinho
        Genero genero = generoRepository.findById(dto.genero().id());
        quadrinho.setGenero(genero);
    
        // Preenchendo a origem do quadrinho
        Origem origem = origemRepository.findById(dto.origem().id());
        quadrinho.setOrigem(origem);
    
        // Preenchendo o escritor do quadrinho
        Pessoa escritor = pessoaRepository.findById(dto.escritor().id());
        quadrinho.setEscritor(escritor);
    
        // Preenchendo o artista de capa do quadrinho
        Pessoa artistaCapa = pessoaRepository.findById(dto.artistaCapa().id());
        quadrinho.setArtistaCapa(artistaCapa);
    }
}
