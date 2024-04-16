package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.model.Categoria;
import br.unitins.comics.repository.CategoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoriaService {
    @Inject
    private CategoriaRepository categoriaRepository;

    @Transactional
    public List<Categoria> findAll() {
        return categoriaRepository.listAll();
    }

    @Transactional
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Transactional
    public void create(Categoria categoria) {
        categoriaRepository.persist(categoria);
    }

    @Transactional
    public void update(Categoria categoria) {
        categoriaRepository.getEntityManager().merge(categoria);
    }

    @Transactional
    public void delete(Long id) {
        Categoria categoria = findById(id);
        if (categoria != null) {
            categoriaRepository.delete(categoria);
        }
    }
}
