package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.PessoaDTO;
import br.unitins.comics.dto.PessoaResponseDTO;

public interface PessoaService {
    void create(PessoaDTO dto);
    void update(Long id, PessoaDTO dto);
    void delete(Long id);
    PessoaResponseDTO findById(Long id);
    List<PessoaResponseDTO> findAll();
    List<PessoaResponseDTO> findByNome(String nome);
}
