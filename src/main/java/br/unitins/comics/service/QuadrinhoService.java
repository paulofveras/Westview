package br.unitins.comics.service;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;

import java.util.List;

public interface QuadrinhoService {

    QuadrinhoResponseDTO create(QuadrinhoDTO dto);

    Object findByNome(String nome);

    void update(Long id, QuadrinhoDTO dto);

    void delete(Long id);

    QuadrinhoResponseDTO findById(Long id);

    List<QuadrinhoResponseDTO> findAll();    
  
}