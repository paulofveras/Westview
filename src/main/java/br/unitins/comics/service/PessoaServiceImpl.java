package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.PessoaDTO;
import br.unitins.comics.dto.PessoaResponseDTO;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService {

    @Inject
    private PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public void create(PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        pessoa.setCpf(dto.cpf());
        pessoa.setEmail(dto.email());
        pessoaRepository.persist(pessoa);
    }

    @Override
    @Transactional
    public void update(Long id, PessoaDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (pessoa != null) {
            pessoa.setNome(dto.nome());
            pessoa.setCpf(dto.cpf());
            pessoa.setEmail(dto.email());
            pessoaRepository.persist(pessoa);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (pessoa != null) {
            pessoaRepository.delete(pessoa);
        }
    }

    @Override
    public PessoaResponseDTO findById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        return PessoaResponseDTO.valueOf(pessoa);
    }

    @Override
    public List<PessoaResponseDTO> findByNome(String nome) {
        return pessoaRepository.findByNome(nome).stream()
            .map(p -> PessoaResponseDTO.valueOf(p)).toList();
    }


    @Override
    public List<PessoaResponseDTO> findAll() {
        List<Pessoa> pessoas = pessoaRepository.listAll();
        return pessoas.stream()
            .map(PessoaResponseDTO::valueOf)
            .toList();
    }
}
