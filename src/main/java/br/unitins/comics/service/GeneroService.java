package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.GeneroDTO;
import br.unitins.comics.dto.GeneroResponseDTO;

public interface GeneroService {
    void create(GeneroDTO dto);
    void update(Long id, GeneroDTO dto);
    void delete(Long id);
    GeneroResponseDTO findById(Long id);
    List<GeneroResponseDTO> findAll();
}
