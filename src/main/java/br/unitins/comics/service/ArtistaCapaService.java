package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ArtistaCapaDTO;
import br.unitins.comics.dto.ArtistaCapaResponseDTO;
import jakarta.validation.Valid;

public interface ArtistaCapaService {
    ArtistaCapaResponseDTO create(@Valid ArtistaCapaDTO dto);
    public void update(Long id, ArtistaCapaDTO dto);
    public void delete(Long id);
    public ArtistaCapaResponseDTO findById(Long id);
    public List<ArtistaCapaResponseDTO> findAll();
    public List<ArtistaCapaResponseDTO> findByNome(String nome);
}
