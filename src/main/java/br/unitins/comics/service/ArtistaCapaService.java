package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ArtistaCapaDTO;
import br.unitins.comics.dto.ArtistaCapaResponseDTO;

public interface ArtistaCapaService {
    void create(ArtistaCapaDTO dto);
    void update(Long id, ArtistaCapaDTO dto);
    void delete(Long id);
    ArtistaCapaResponseDTO findById(Long id);
    List<ArtistaCapaResponseDTO> findAll();
    List<ArtistaCapaResponseDTO> findByNome(String nome);
}
