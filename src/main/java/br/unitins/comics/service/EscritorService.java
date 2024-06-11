package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.EscritorDTO;
import br.unitins.comics.dto.EscritorResponseDTO;
import jakarta.validation.Valid;

public interface EscritorService {
    EscritorResponseDTO create(@Valid EscritorDTO dto);
    public void update(Long id, EscritorDTO dto);
    public void delete(Long id);
    public EscritorResponseDTO findById(Long id);
    public List<EscritorResponseDTO> findAll();
    public List<EscritorResponseDTO> findByNome(String nome);
}
