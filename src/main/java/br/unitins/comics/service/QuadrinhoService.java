package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;
import jakarta.validation.Valid;

public interface QuadrinhoService {

    public QuadrinhoResponseDTO create(@Valid QuadrinhoDTO dto);

    public void update(Long id, QuadrinhoDTO dto);

    public void delete(Long id);

    public QuadrinhoResponseDTO findById(Long id);

    public List<QuadrinhoResponseDTO> findAll();

    public List<QuadrinhoResponseDTO> findByNome(String nome);
}
