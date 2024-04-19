package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.CategoriaDTO;
import br.unitins.comics.dto.CategoriaResponseDTO;
import br.unitins.comics.model.Categoria;
import br.unitins.comics.repository.CategoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoriaServiceImpl implements CategoriaService {

    @Inject
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public void create(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setUniverso(dto.universo());
        categoriaRepository.persist(categoria);
    }

    @Override
    @Transactional
    public void update(Long id, CategoriaDTO dto) {
        Categoria categoria = categoriaRepository.findById(id);
        if (categoria != null) {
            categoria.setUniverso(dto.universo());
            categoriaRepository.persist(categoria);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Categoria categoria = categoriaRepository.findById(id);
        if (categoria != null) {
            categoriaRepository.delete(categoria);
        }
    }

    @Override
    public CategoriaResponseDTO findById(Long id) {
        Categoria categoria = categoriaRepository.findById(id);
        return CategoriaResponseDTO.valueOf(categoria);
    }

    @Override
    public List<CategoriaResponseDTO> findAll() {
        List<Categoria> categorias = categoriaRepository.listAll();
        return categorias.stream()
            .map(CategoriaResponseDTO::valueOf)
            .toList();
    }
}