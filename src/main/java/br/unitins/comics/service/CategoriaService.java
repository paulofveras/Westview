package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.CategoriaDTO;
import br.unitins.comics.dto.CategoriaResponseDTO;

public interface CategoriaService {
    void create(CategoriaDTO dto);
    void update(Long id, CategoriaDTO dto);
    void delete(Long id);
    CategoriaResponseDTO findById(Long id);
    List<CategoriaResponseDTO> findAll();
}