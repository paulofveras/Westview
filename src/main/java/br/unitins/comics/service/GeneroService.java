package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.model.Genero;
import br.unitins.comics.repository.GeneroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GeneroService {
    @Inject
    private GeneroRepository generoRepository;

    @Transactional
    public List<Genero> findAll() {
        return generoRepository.listAll();
    }

    @Transactional
    public Genero findById(Long id) {
        return generoRepository.findById(id);
    }

    @Transactional
    public void create(Genero genero) {
        generoRepository.persist(genero);
    }

    @Transactional
    public void update(Genero genero) {
        generoRepository.getEntityManager().merge(genero);
    }

    @Transactional
    public void delete(Long id) {
        Genero genero = findById(id);
        if (genero != null) {
            generoRepository.delete(genero);
        }
    }
}
