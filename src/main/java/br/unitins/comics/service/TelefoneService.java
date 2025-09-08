package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.TelefoneDTO;
import br.unitins.comics.dto.TelefoneResponseDTO;
import jakarta.validation.Valid;

public interface TelefoneService {

    public TelefoneResponseDTO create(@Valid TelefoneDTO dto);

    public void update(Long id, TelefoneDTO dto);

    public void delete(Long id);

    public TelefoneResponseDTO findById(Long id);

    public List<TelefoneResponseDTO> findAll();
}
