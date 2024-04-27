package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.GeneroDTO;
import br.unitins.comics.dto.GeneroResponseDTO;
import jakarta.validation.Valid;

public interface GeneroService {
    GeneroResponseDTO create(@Valid GeneroDTO dto);
    void update(Long id, GeneroDTO dto);
    void delete(Long id);
    GeneroResponseDTO findById(Long id);
    List<GeneroResponseDTO> findAll();
}
