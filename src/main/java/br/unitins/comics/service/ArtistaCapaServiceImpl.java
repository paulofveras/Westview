package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ArtistaCapaDTO;
import br.unitins.comics.dto.ArtistaCapaResponseDTO;
import br.unitins.comics.model.ArtistaCapa;
import br.unitins.comics.repository.ArtistaCapaRepository;
import br.unitins.comics.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ArtistaCapaServiceImpl implements ArtistaCapaService{
    @Inject
    public ArtistaCapaRepository artistaCapaRepository;

    @Override
    @Transactional
    public ArtistaCapaResponseDTO create(@Valid ArtistaCapaDTO dto){
        validarNomeCompletoArtistaCapa(dto.nome());

        ArtistaCapa artistaCapa = new ArtistaCapa();
        artistaCapa.setNome(dto.nome());

        artistaCapaRepository.persist(artistaCapa);
        return ArtistaCapaResponseDTO.valueOf(artistaCapa);
    }

    public void validarNomeCompletoArtistaCapa(String nome) {
        ArtistaCapa artistaCapa = artistaCapaRepository.findByNomeCompleto(nome);
        if (artistaCapa != null)
            throw  new ValidationException("nome", "O nome '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, ArtistaCapaDTO dto){
        ArtistaCapa artistaCapaBanco = artistaCapaRepository.findById(id);

        artistaCapaBanco.setNome(dto.nome());
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

    @Override
    public List<ArtistaCapaResponseDTO> findAll(){
        return artistaCapaRepository.listAll().stream().map(artistaCapa -> ArtistaCapaResponseDTO.valueOf(artistaCapa)).toList();
    }

    @Override
    public List<ArtistaCapaResponseDTO> findByNome(String nome){
        return artistaCapaRepository.findByNome(nome).stream().map(artistaCapa -> ArtistaCapaResponseDTO.valueOf(artistaCapa)).toList();
    }
}