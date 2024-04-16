package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.model.Pessoa;
import br.unitins.comics.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PessoaService {
    @Inject
    private PessoaRepository pessoaRepository;

    @Transactional
    public List<Pessoa> findAll() {
        return pessoaRepository.listAll();
    }

    @Transactional
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Transactional
    public void create(Pessoa pessoa) {
        pessoaRepository.persist(pessoa);
    }

    @Transactional
    public void update(Pessoa pessoa) {
        pessoaRepository.getEntityManager().merge(pessoa);
    }

    @Transactional
    public void delete(Long id) {
        Pessoa pessoa = findById(id);
        if (pessoa != null) {
            pessoaRepository.delete(pessoa);
        }
    }
}
