package br.unitins.comics.service;

<<<<<<< HEAD
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
=======
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
>>>>>>> ee80e95e1f4b3b188d07fdf23b8684f8dd807b6e
