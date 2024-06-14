package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ArtistaCapaDTO;
import br.unitins.comics.dto.ArtistaCapaResponseDTO;
import jakarta.validation.Valid;

public interface ArtistaCapaService {
    ArtistaCapaResponseDTO create(@Valid ArtistaCapaDTO dto);
    void update(Long id, ArtistaCapaDTO dto);
    void delete(Long id);
    ArtistaCapaResponseDTO findById(Long id);
    List<ArtistaCapaResponseDTO> findAll();
    List<ArtistaCapaResponseDTO> findByNome(String nome);
}
