package br.unitins.comics.service;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;
import br.unitins.comics.model.Quadrinho;
import br.unitins.comics.repository.QuadrinhoRepository;
import br.unitins.comics.model.Categoria;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.repository.CategoriaRepository;
import br.unitins.comics.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuadrinhoServiceImpl implements QuadrinhoService {

    @Inject
    public QuadrinhoRepository quadrinhoRepository;

    @Inject
    public CategoriaRepository categoriaRepository;

    @Inject
    public PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public QuadrinhoResponseDTO create(@Valid QuadrinhoDTO dto) {
        validarNomeQuadrinho(dto.getNome());

        // Busca a Categoria pelo ID
        Categoria categoria = categoriaRepository.findById(dto.getCategoria().getId());

        // Busca o Escritor pelo ID
        Pessoa escritor = pessoaRepository.findById(dto.getEscritor().getId());

        // Busca o ArtistaCapa pelo ID
        Pessoa artistaCapa = pessoaRepository.findById(dto.getArtistaCapa().getId());

        Quadrinho quadrinho = new Quadrinho();
        quadrinho.setNome(dto.getNome());
        quadrinho.setDataPublicacao(dto.getDataPublicacao());
        quadrinho.setEdicao(dto.getEdicao());
        quadrinho.setDescricao(dto.getDescricao());
        quadrinho.setPreco(dto.getPreco());
        quadrinho.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        quadrinho.setCategoria(categoria);
        quadrinho.setPersonagens(dto.getPersonagens());
        quadrinho.setEscritor(escritor);
        quadrinho.setArtistaCapa(artistaCapa);

        quadrinhoRepository.persist(quadrinho);
        return QuadrinhoResponseDTO.valueOf(quadrinho);
    }

    @Override
    @Transactional
    public void update(Long id, QuadrinhoDTO dto) {
        Quadrinho quadrinhoBanco = quadrinhoRepository.findById(id);
        if (quadrinhoBanco == null) {
            throw new jakarta.validation.ValidationException("Quadrinho não encontrado.");
        }
    
        validarNomeQuadrinho(dto.getNome());
    
        Categoria categoria = categoriaRepository.findById(dto.getCategoria().getId());
        Pessoa escritor = pessoaRepository.findById(dto.getEscritor());
        Pessoa artistaCapa = pessoaRepository.findById(dto.getArtistaCapa());
    
        quadrinhoBanco.setNome(dto.getNome());
        quadrinhoBanco.setDataPublicacao(dto.getDataPublicacao());
        quadrinhoBanco.setEdicao(dto.getEdicao());
        quadrinhoBanco.setDescricao(dto.getDescricao());
        quadrinhoBanco.setPreco(dto.getPreco());
        quadrinhoBanco.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        quadrinhoBanco.setCategoria(categoria);
        quadrinhoBanco.setPersonagens(dto.getPersonagens());
        quadrinhoBanco.setEscritor(escritor);
        quadrinhoBanco.setArtistaCapa(artistaCapa);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        quadrinhoRepository.deleteById(id);
    }

    @Override
    public QuadrinhoResponseDTO findById(Long id) {
        Quadrinho quadrinho = quadrinhoRepository.findById(id);
        if (quadrinho == null) {
            throw new jakarta.validation.ValidationException("Quadrinho não encontrado.");
        }
        return QuadrinhoResponseDTO.valueOf(quadrinho);
    }

@Override
public List<QuadrinhoResponseDTO> findAll() {
    List<Quadrinho> quadrinhos = quadrinhoRepository.listAll();
    List<QuadrinhoResponseDTO> responseDTOs = new ArrayList<>();
    for (Quadrinho quadrinho : quadrinhos) {
        responseDTOs.add(QuadrinhoResponseDTO.valueOf(quadrinho));
    }
    return responseDTOs;
}

    @Override
    public List<QuadrinhoResponseDTO> findByNome(String nome) {
        Quadrinho quadrinho = quadrinhoRepository.findByNome(nome);
        if (quadrinho != null) {
            QuadrinhoResponseDTO quadrinhoDTO = QuadrinhoResponseDTO.valueOf(quadrinho);
            List<QuadrinhoResponseDTO> quadrinhosEncontrados = new ArrayList<>();
            quadrinhosEncontrados.add(quadrinhoDTO);
            return quadrinhosEncontrados;
        } else {
            return new ArrayList<>();
        }
    }

    private void validarNomeQuadrinho(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new jakarta.validation.ValidationException("Nome do quadrinho não pode ser vazio.");
        }
    }
}