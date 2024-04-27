package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.GeneroDTO;
import br.unitins.comics.dto.GeneroResponseDTO;
import br.unitins.comics.model.Genero;
import br.unitins.comics.repository.GeneroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class GeneroServiceImpl implements GeneroService {

    @Inject
    private GeneroRepository generoRepository;

    @Override
    @Transactional
    public GeneroResponseDTO create(@Valid GeneroDTO dto) {
        Genero genero = new Genero();
        genero.setGenero(dto.genero());
        genero.setDescricao(dto.descricao());
        generoRepository.persist(genero);
        
        return GeneroResponseDTO.valueOf(genero);
    }

    @Override
    @Transactional
    public void update(Long id, GeneroDTO dto) {
       Genero generoBanco = generoRepository.findById(id);

       generoBanco.setGenero(dto.genero());
       generoBanco.setDescricao(dto.descricao());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        generoRepository.deleteById(id);
    }

    @Override
    public GeneroResponseDTO findById(Long id) {
        return GeneroResponseDTO.valueOf(generoRepository.findById(id));
    }

    @Override
    public List<GeneroResponseDTO> findAll() {
        return generoRepository.listAll().stream().map(generos -> GeneroResponseDTO.valueOf(generos)).toList();
    }
}