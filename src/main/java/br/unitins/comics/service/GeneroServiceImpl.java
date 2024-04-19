package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.GeneroDTO;
import br.unitins.comics.dto.GeneroResponseDTO;
import br.unitins.comics.model.Genero;
import br.unitins.comics.repository.GeneroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GeneroServiceImpl implements GeneroService {

    @Inject
    private GeneroRepository generoRepository;

    @Override
    @Transactional
    public void create(GeneroDTO dto) {
        Genero genero = new Genero();
        genero.setGenero(dto.genero());
        genero.setDescricao(dto.descricao());
        generoRepository.persist(genero);
    }

    @Override
    @Transactional
    public void update(Long id, GeneroDTO dto) {
        Genero genero = generoRepository.findById(id);
        if (genero != null) {
            genero.setGenero(dto.genero());
            genero.setDescricao(dto.descricao());
            generoRepository.persist(genero);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Genero genero = generoRepository.findById(id);
        if (genero != null) {
            generoRepository.delete(genero);
        }
    }

    @Override
    public GeneroResponseDTO findById(Long id) {
        Genero genero = generoRepository.findById(id);
        return GeneroResponseDTO.valueOf(genero);
    }

    @Override
    public List<GeneroResponseDTO> findAll() {
        List<Genero> generos = generoRepository.listAll();
        return generos.stream()
            .map(GeneroResponseDTO::valueOf)
            .toList();
    }
}