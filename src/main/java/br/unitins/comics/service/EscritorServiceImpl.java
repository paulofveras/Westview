package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.EscritorDTO;
import br.unitins.comics.dto.EscritorResponseDTO;
import br.unitins.comics.model.Escritor;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.repository.EscritorRepository;
import br.unitins.comics.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EscritorServiceImpl implements EscritorService {

    @Inject
    private EscritorRepository escritorRepository;

    @Inject
    private PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public void create(EscritorDTO dto) {
        // Verifica se o ID da Pessoa no DTO é válido
        if (dto.pessoa() == null || dto.pessoa().id() == null) {
            throw new IllegalArgumentException("ID da Pessoa não fornecido.");
        }

        // Busca a Pessoa no banco de dados pelo ID
        Pessoa pessoa = pessoaRepository.findById(dto.pessoa().id());
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não encontrada para o ID fornecido.");
        }

        // Cria um novo Escritor e associa a Pessoa
        Escritor escritor = new Escritor();
        escritor.setPessoa(pessoa);

        // Persiste o Escritor
        escritorRepository.persist(escritor);
    }

    @Override
    @Transactional
    public void update(Long id, EscritorDTO dto) {
        Escritor escritor = escritorRepository.findById(id);
        if (escritor != null) {
            // Verifica se o ID da Pessoa no DTO é válido
            if (dto.pessoa() == null || dto.pessoa().id() == null) {
                throw new IllegalArgumentException("ID da Pessoa não fornecido.");
            }

            // Busca a Pessoa no banco de dados pelo ID
            Pessoa pessoa = pessoaRepository.findById(dto.pessoa().id());
            if (pessoa == null) {
                throw new IllegalArgumentException("Pessoa não encontrada para o ID fornecido.");
            }

            // Atualiza o Escritor com os novos dados da Pessoa
            escritor.setPessoa(pessoa);

            // Persiste as alterações
            escritorRepository.persist(escritor);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Escritor escritor = escritorRepository.findById(id);
        if (escritor != null) {
            escritorRepository.delete(escritor);
        }
    }

    @Override
    public EscritorResponseDTO findById(Long id) {
        Escritor escritor = escritorRepository.findById(id);
        return EscritorResponseDTO.valueOf(escritor);
    }

    @Override
    public List<EscritorResponseDTO> findByNome(String nome) {
        return escritorRepository.findByNome(nome).stream()
            .map(e -> EscritorResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<EscritorResponseDTO> findAll() {
        List<Escritor> escritores = escritorRepository.listAll();
        return escritores.stream()
            .map(EscritorResponseDTO::valueOf)
            .toList();
    }
}
