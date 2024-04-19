package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.OrigemDTO;
import br.unitins.comics.dto.OrigemResponseDTO;

public interface OrigemService {
    void create(OrigemDTO dto);
    void update(Long id, OrigemDTO dto);
    void delete(Long id);
    OrigemResponseDTO findById(Long id);
    List<OrigemResponseDTO> findAll();
}