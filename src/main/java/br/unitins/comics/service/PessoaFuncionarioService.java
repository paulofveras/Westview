package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.PessoaFuncionarioDTO;
import br.unitins.comics.model.PessoaFuncionario;
import br.unitins.comics.repository.PessoaFuncionarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PessoaFuncionarioService {
    @Inject
    private PessoaFuncionarioRepository pessoaFuncionarioRepository;

    @Transactional
    public PessoaFuncionario criarPessoaFuncionario(PessoaFuncionarioDTO pessoaFuncionarioDTO) {
        PessoaFuncionario pessoaFuncionario = new PessoaFuncionario();
        pessoaFuncionario.setPessoa(pessoaFuncionarioDTO.getPessoa());
        pessoaFuncionario.setCargo(pessoaFuncionarioDTO.getCargo());
        // pessoaFuncionario.setSalario(pessoaFuncionarioDTO.getSalario());
        // pessoaFuncionario.setDepartamento(pessoaFuncionarioDTO.getDepartamento());
        pessoaFuncionarioRepository.persist(pessoaFuncionario);
        return pessoaFuncionario;
    }

    public List<PessoaFuncionario> listarPessoaFuncionarios() {
        return pessoaFuncionarioRepository.listAll();
    }

    public PessoaFuncionario buscarPessoaFuncionario(Long id) {
        return pessoaFuncionarioRepository.findById(id);
    }

    @Transactional
    public void atualizarPessoaFuncionario(Long id, PessoaFuncionarioDTO pessoaFuncionarioDTO) {
        PessoaFuncionario pessoaFuncionario = buscarPessoaFuncionario(id);
        if (pessoaFuncionario != null) {
            pessoaFuncionario.setPessoa(pessoaFuncionarioDTO.getPessoa());
            pessoaFuncionario.setCargo(pessoaFuncionarioDTO.getCargo());
            // pessoaFuncionario.setSalario(pessoaFuncionarioDTO.getSalario());
            // pessoaFuncionario.setDepartamento(pessoaFuncionarioDTO.getDepartamento());
            pessoaFuncionarioRepository.persist(pessoaFuncionario);
        }
    }

    @Transactional
    public void excluirPessoaFuncionario(Long id) {
        PessoaFuncionario pessoaFuncionario = buscarPessoaFuncionario(id);
        if (pessoaFuncionario != null) {
            pessoaFuncionarioRepository.delete(pessoaFuncionario);
        }
    }
}
