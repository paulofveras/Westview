package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;

public interface QuadrinhoService {
    QuadrinhoResponseDTO create(QuadrinhoDTO dto);
    void update(Long id, QuadrinhoDTO dto);
    void delete(Long id);
    QuadrinhoResponseDTO findById(Long id);
    List<QuadrinhoResponseDTO> findAll();
}
