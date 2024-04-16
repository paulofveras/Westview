package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.model.Origem;
import br.unitins.comics.repository.OrigemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrigemService {
    @Inject
    private OrigemRepository origemRepository;

    @Transactional
    public List<Origem> findAll() {
        return origemRepository.listAll();
    }

    @Transactional
    public Origem findById(Long id) {
        return origemRepository.findById(id);
    }

    @Transactional
    public void create(Origem origem) {
        origemRepository.persist(origem);
    }

    @Transactional
    public void update(Origem origem) {
        origemRepository.getEntityManager().merge(origem);
    }

    @Transactional
    public void delete(Long id) {
        Origem origem = findById(id);
        if (origem != null) {
            origemRepository.delete(origem);
        }
    }
}
