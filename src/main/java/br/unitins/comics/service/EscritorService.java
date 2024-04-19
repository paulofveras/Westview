package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.EscritorDTO;
import br.unitins.comics.dto.EscritorResponseDTO;

public interface EscritorService {
    void create(EscritorDTO dto);
    void update(Long id, EscritorDTO dto);
    void delete(Long id);
    EscritorResponseDTO findById(Long id);
    List<EscritorResponseDTO> findAll();
    List<EscritorResponseDTO> findByNome(String nome);
}
