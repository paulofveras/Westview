package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.FuncionarioDTO;
import br.unitins.comics.dto.FuncionarioResponseDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface FuncionarioService {
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto);
    public void update(Long id, FuncionarioDTO dto);
    public void delete(Long id);
    public FuncionarioResponseDTO findById(Long id);
    public List<FuncionarioResponseDTO> findAll();
    public List<FuncionarioResponseDTO> findByCargo(String cargo);
    public List<UsuarioResponseDTO> findByCpf(String cpf);
    public UsuarioResponseDTO login(String username, String senha);
}
