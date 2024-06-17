package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.EnderecoDTO;
import br.unitins.comics.dto.EnderecoResponseDTO;
import jakarta.validation.Valid;

public interface EnderecoService {

    public EnderecoResponseDTO create(@Valid EnderecoDTO dto);

    public void update(Long id, EnderecoDTO dto);

    public void delete(Long id);

    public EnderecoResponseDTO findById(Long id);

    public List<EnderecoResponseDTO> findAll();

}
