package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.EscritorDTO;
import br.unitins.comics.dto.EscritorResponseDTO;
import br.unitins.comics.dto.PessoaResponseDTO;
import br.unitins.comics.model.Escritor;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.repository.EscritorRepository;
import br.unitins.comics.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.comics.validation.ValidationException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class EscritorServiceImpl implements EscritorService {

    @Inject
    private EscritorRepository escritorRepository;

    @Inject
    public PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public EscritorResponseDTO create(@Valid EscritorDTO dto) {
        Escritor escritor = new Escritor();
        validarCpfCliente(dto.cpf());
        
         // Criar uma instância de Usuario com os dados do ClienteDTO
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setCpf(dto.cpf());


        // Persistir o Usuario no banco de dados antes de associá-lo ao Cliente
        pessoaRepository.persist(pessoa);
    
        escritor.setPessoa(pessoa);
        // set other fields of Escritor from dto if any
        return EscritorResponseDTO.valueOf(escritor);
    }

        public void validarCpfCliente(String cpf){
        Pessoa cliente = pessoaRepository.findByCpfPessoa(cpf);
        if (cliente != null)
        throw  new ValidationException("cpf", "O  CPF: '"+ cpf +"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, EscritorDTO dto){
        Escritor escritorBanco = escritorRepository.findById(id);

         // Criar uma instância de Usuario com os dados do ClienteDTO
        Pessoa pessoa =  escritorBanco.getPessoa();
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setCpf(dto.cpf());
    }

    @Override
    @Transactional
    public void delete(Long id){
        escritorRepository.deleteById(id);
    }

    @Override
    public EscritorResponseDTO findById(Long id){
        return EscritorResponseDTO.valueOf(escritorRepository.findById(id));
    }

    @GET
    public List<EscritorResponseDTO> findAll(){
        return escritorRepository.listAll().stream().map(a -> EscritorResponseDTO.valueOf(a)).toList();
    }
    
    @Override
    public List<PessoaResponseDTO> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).stream().map(c -> PessoaResponseDTO.valueOf(c)).toList();
    }

    @Override
    public List<EscritorResponseDTO> findByNome(String nome) {
        return escritorRepository.findByNome(nome).stream().map(escritor -> EscritorResponseDTO.valueOf(escritor)).toList();
    }
}
