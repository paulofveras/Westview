package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.CategoriaDTO;
import br.unitins.comics.dto.CategoriaResponseDTO;
import br.unitins.comics.model.Categoria;
import br.unitins.comics.repository.CategoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CategoriaServiceImpl implements CategoriaService {

    @Inject
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public CategoriaResponseDTO create(@Valid CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setUniverso(dto.universo());
        categoriaRepository.persist(categoria);

        return CategoriaResponseDTO.valueOf(categoria);
    }

    @Override
    @Transactional
    public void update(Long id, CategoriaDTO dto) {
        Categoria categoriaBanco = categoriaRepository.findById(id);

        categoriaBanco.setUniverso(dto.universo());
    }

    @Override
    @Transactional
    public void delete(Long id) {
       categoriaRepository.deleteById(id);
    }

    @Override
    public CategoriaResponseDTO findById(Long id) {
        return CategoriaResponseDTO.valueOf(categoriaRepository.findById(id));
    }

    @Override
    public List<CategoriaResponseDTO> findAll() {
        return categoriaRepository.listAll().stream().map(categorias -> CategoriaResponseDTO.valueOf(categorias)).toList();
    }
}