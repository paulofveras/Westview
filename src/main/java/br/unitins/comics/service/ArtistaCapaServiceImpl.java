package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ArtistaCapaDTO;
import br.unitins.comics.dto.ArtistaCapaResponseDTO;
import br.unitins.comics.dto.PessoaDTO;
import br.unitins.comics.model.ArtistaCapa;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.repository.ArtistaCapaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ArtistaCapaServiceImpl implements ArtistaCapaService {

    @Inject
    private ArtistaCapaRepository artistaCapaRepository;

    @Override
    @Transactional
    public void create(ArtistaCapaDTO dto) {
        ArtistaCapa artistaCapa = new ArtistaCapa();
        Pessoa pessoa = new Pessoa();
        PessoaDTO pessoaDTO = dto.pessoa();
        pessoa.setNome(pessoaDTO.nome());
        pessoa.setCpf(pessoaDTO.cpf());
        pessoa.setEmail(pessoaDTO.email());
    
        artistaCapa.setPessoa(pessoa);
        // set other fields of ArtistaCapa from dto if any
    
        artistaCapaRepository.persist(artistaCapa);
    }

    @Override
    @Transactional
    public void update(Long id, ArtistaCapaDTO dto) {
        ArtistaCapa artistaCapa = artistaCapaRepository.findById(id);
        if (artistaCapa != null) {
            Pessoa pessoa = artistaCapa.getPessoa();
            PessoaDTO pessoaDTO = dto.pessoa();
            pessoa.setNome(pessoaDTO.nome());
            pessoa.setCpf(pessoaDTO.cpf());
            pessoa.setEmail(pessoaDTO.email());
    
            artistaCapaRepository.persist(artistaCapa);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ArtistaCapa artistaCapa = artistaCapaRepository.findById(id);
        if (artistaCapa != null) {
            artistaCapaRepository.delete(artistaCapa);
        }
    }

    @Override
    public ArtistaCapaResponseDTO findById(Long id) {
        ArtistaCapa artistaCapa = artistaCapaRepository.findById(id);
        return ArtistaCapaResponseDTO.valueOf(artistaCapa);
    }

    @Override
    public List<ArtistaCapaResponseDTO> findByNome(String nome) {
        return artistaCapaRepository.findByNome(nome).stream()
            .map(a -> ArtistaCapaResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<ArtistaCapaResponseDTO> findAll() {
        List<ArtistaCapa> artistasCapa = artistaCapaRepository.listAll();
        return artistasCapa.stream()
            .map(ArtistaCapaResponseDTO::valueOf)
            .toList();
    }
}