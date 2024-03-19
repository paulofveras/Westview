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
    public Pessoa criarPessoa(Pessoa pessoa) {
        pessoaRepository.persist(pessoa);
        return pessoa;
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.listAll();
    }

    public Pessoa buscarPessoa(Long id) {
        return pessoaRepository.findById(id);
    }

    @Transactional
    public void atualizarPessoa(Long id, Pessoa pessoa) {
        Pessoa pessoaExistente = buscarPessoa(id);
        if (pessoaExistente != null) {
            pessoaExistente.setNome(pessoa.getNome());
            pessoaExistente.setCpf(pessoa.getCpf());
            pessoaRepository.persist(pessoaExistente);
        }
    }

    @Transactional
    public void excluirPessoa(Long id) {
        Pessoa pessoa = buscarPessoa(id);
        if (pessoa != null) {
            pessoaRepository.delete(pessoa);
        }
    }
}
