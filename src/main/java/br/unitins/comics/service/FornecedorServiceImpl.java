package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.FornecedorDTO;
import br.unitins.comics.dto.FornecedorResponseDTO;
import br.unitins.comics.model.Fornecedor;
import br.unitins.comics.repository.EnderecoRepository;
import br.unitins.comics.repository.FornecedorRepository;
import br.unitins.comics.repository.TelefoneRepository;
import br.unitins.comics.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService {

    @Inject
    public FornecedorRepository fornecedorRepository;
    @Inject
    public EnderecoRepository enderecoRepository;
    @Inject
    public TelefoneRepository telefoneRepository;

    @Override
    @Transactional
    public FornecedorResponseDTO create(@Valid FornecedorDTO dto) {
        validarNomeFornecedor(dto.nome());

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setEndereco(enderecoRepository.findById(dto.id_endereco()));
        fornecedor.setTelefone(telefoneRepository.findById(dto.id_telefone()));
        fornecedor.setEmail(dto.email());


        fornecedorRepository.persist(fornecedor);
        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    public void validarNomeFornecedor(String nome) {
        Fornecedor fornecedor = fornecedorRepository.findByNomeCompleto(nome);
        if (fornecedor != null)
            throw  new ValidationException("nome", "O nome '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, FornecedorDTO dto) {
        Fornecedor fornecedorBanco =  fornecedorRepository.findById(id);
        
        fornecedorBanco.setNome(dto.nome());
        fornecedorBanco.setEndereco(enderecoRepository.findById(dto.id_endereco()));
        fornecedorBanco.setTelefone(telefoneRepository.findById(dto.id_telefone()));
        fornecedorBanco.setEmail(dto.email());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }

    @Override
    public FornecedorResponseDTO findById(Long id) {
        return FornecedorResponseDTO.valueOf(fornecedorRepository.findById(id));
    }

    @Override
    public List<FornecedorResponseDTO> findAll() {
        return fornecedorRepository
        .listAll()
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<FornecedorResponseDTO> findByNome(String nome) {
        return fornecedorRepository.findByNome(nome).stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }

}
