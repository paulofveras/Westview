package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ArtistaCapaDTO;
import br.unitins.comics.dto.ArtistaCapaResponseDTO;
import br.unitins.comics.dto.PessoaResponseDTO;
import br.unitins.comics.model.ArtistaCapa;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.repository.ArtistaCapaRepository;
import br.unitins.comics.repository.PessoaRepository;
import br.unitins.comics.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class ArtistaCapaServiceImpl implements ArtistaCapaService {

    @Inject
    private ArtistaCapaRepository artistaCapaRepository;

    @Inject
    public PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public ArtistaCapaResponseDTO create(@Valid ArtistaCapaDTO dto) {
        ArtistaCapa artistaCapa = new ArtistaCapa();
        validarCpfCliente(dto.cpf());
        
         // Criar uma instância de Usuario com os dados do ClienteDTO
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setCpf(dto.cpf());


        // Persistir o Usuario no banco de dados antes de associá-lo ao Cliente
        pessoaRepository.persist(pessoa);
    
        artistaCapa.setPessoa(pessoa);
        // set other fields of ArtistaCapa from dto if any
        return ArtistaCapaResponseDTO.valueOf(artistaCapa);
    }

        public void validarCpfCliente(String cpf){
        Pessoa cliente = pessoaRepository.findByCpfPessoa(cpf);
        if (cliente != null)
        throw  new ValidationException("cpf", "O  CPF: '"+ cpf +"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, ArtistaCapaDTO dto){
        ArtistaCapa artistaCapaBanco = artistaCapaRepository.findById(id);

         // Criar uma instância de Usuario com os dados do ClienteDTO
        Pessoa pessoa =  artistaCapaBanco.getPessoa();
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setCpf(dto.cpf());
    }

    @Override
    @Transactional
    public void delete(Long id){
        artistaCapaRepository.deleteById(id);
    }

    @Override
    public ArtistaCapaResponseDTO findById(Long id){
        return ArtistaCapaResponseDTO.valueOf(artistaCapaRepository.findById(id));
    }

    @GET
    public List<ArtistaCapaResponseDTO> findAll(){
        return artistaCapaRepository.listAll().stream().map(a -> ArtistaCapaResponseDTO.valueOf(a)).toList();
    }
    
    @Override
    public List<PessoaResponseDTO> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).stream().map(c -> PessoaResponseDTO.valueOf(c)).toList();
    }

    @Override
    public List<ArtistaCapaResponseDTO> findByNome(String nome) {
        return artistaCapaRepository.findByNome(nome).stream()
        .map(e -> ArtistaCapaResponseDTO.valueOf(e)).toList();
    }
}