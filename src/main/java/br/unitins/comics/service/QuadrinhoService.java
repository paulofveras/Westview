package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;
import jakarta.validation.Valid;

public interface QuadrinhoService {
    QuadrinhoResponseDTO create(@Valid QuadrinhoDTO dto);
    void update(Long id, QuadrinhoDTO dto);
    void delete(Long id);
    QuadrinhoResponseDTO findById(Long id);
    List<QuadrinhoResponseDTO> findByNome(String nome);
    List<QuadrinhoResponseDTO> findAll();
}
