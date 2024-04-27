package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ArtistaCapaDTO;
import br.unitins.comics.dto.ArtistaCapaResponseDTO;
import br.unitins.comics.dto.PessoaResponseDTO;

public interface ArtistaCapaService {
    ArtistaCapaResponseDTO create(ArtistaCapaDTO dto);
    void update(Long id, ArtistaCapaDTO dto);
    void delete(Long id);
    ArtistaCapaResponseDTO findById(Long id);
    List<ArtistaCapaResponseDTO> findAll();
    List<ArtistaCapaResponseDTO> findByNome(String nome);
    List<PessoaResponseDTO> findByCpf(String cpf);
}
