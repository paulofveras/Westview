package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;
import br.unitins.comics.model.Classificacao;
import br.unitins.comics.model.Quadrinho;
import br.unitins.comics.repository.ArtistaCapaRepository;
import br.unitins.comics.repository.CategoriaRepository;
import br.unitins.comics.repository.EscritorRepository;
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
    public QuadrinhoRepository quadrinhoRepository;

    @Inject
    public CategoriaRepository categoriaRepository;

    @Inject
    public PessoaRepository pessoaRepository;

    @Inject
    public EscritorRepository escritorRepository;

    @Inject
    public ArtistaCapaRepository artistaCapaRepository;

    @Inject
    public GeneroRepository generoRepository;

    @Inject
    public OrigemRepository origemRepository;

    @Override
    @Transactional
    public QuadrinhoResponseDTO create(QuadrinhoDTO dto) {

        Quadrinho quadrinho = new Quadrinho();
        quadrinho.setNome(dto.nome());
        quadrinho.setDataPublicacao(dto.dataPublicacao());
        quadrinho.setEdicao(dto.edicao());
        quadrinho.setPreco(dto.preco());
        quadrinho.setQuantidadeEstoque(dto.quantidadeEstoque());
        quadrinho.setCategoria(categoriaRepository.findById(dto.categoria()));

        quadrinho.setListaEscritor((dto.escritores().stream().map(a -> escritorRepository.findById(a)).toList()));

        quadrinho.setListaArtistaCapa((dto.artistaCapa().stream().map(a -> artistaCapaRepository.findById(a)).toList()));

        quadrinho.setClassificacao(Classificacao.valueOf(dto.id_classificacao()));
        
        quadrinho.setGenero(generoRepository.findById(dto.genero()));

        quadrinho.setOrigem(origemRepository.findById(dto.origem()));

        quadrinhoRepository.persist(quadrinho);
        return QuadrinhoResponseDTO.valueOf(quadrinho);
    }

    @Override
    @Transactional
    public void update(Long id, QuadrinhoDTO dto) {
        Quadrinho quadrinhoBanco =  quadrinhoRepository.findById(id);

        quadrinhoBanco.setNome(dto.nome());
        quadrinhoBanco.setDataPublicacao(dto.dataPublicacao());
        quadrinhoBanco.setEdicao(dto.edicao());
        quadrinhoBanco.setPreco(dto.preco());
        quadrinhoBanco.setQuantidadeEstoque(dto.quantidadeEstoque());
        quadrinhoBanco.setCategoria(categoriaRepository.findById(dto.categoria()));

        quadrinhoBanco.setListaEscritor((dto.escritores().stream().map(a -> escritorRepository.findById(a)).toList()));

        quadrinhoBanco.setListaArtistaCapa((dto.artistaCapa().stream().map(a -> artistaCapaRepository.findById(a)).toList()));

        quadrinhoBanco.setClassificacao(Classificacao.valueOf(dto.id_classificacao()));
        
        quadrinhoBanco.setGenero(generoRepository.findById(dto.genero()));

        quadrinhoBanco.setOrigem(origemRepository.findById(dto.origem()));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        quadrinhoRepository.deleteById(id);
    }

    @Override
    public List<QuadrinhoResponseDTO> findAll() {
        return quadrinhoRepository.listAll().stream().map(quadrinho -> QuadrinhoResponseDTO.valueOf(quadrinho)).toList();
    }

    @Override
    public QuadrinhoResponseDTO findById(Long id) {
        return QuadrinhoResponseDTO.valueOf(quadrinhoRepository.findById(id));
    }

    @Override
    public List<QuadrinhoResponseDTO> findByNome(String nome) {
        return quadrinhoRepository.findByNome(nome).stream()
        .map(e -> QuadrinhoResponseDTO.valueOf(e)).toList();
    }

}
