package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ClienteDTO;
import br.unitins.comics.dto.ClienteResponseDTO;
import br.unitins.comics.dto.UpdatePasswordDTO;
import br.unitins.comics.dto.UpdateUsernameDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface ClienteService {
    ClienteResponseDTO create(@Valid ClienteDTO dto);
    void update(Long id, ClienteDTO dto);
    void updatePassword(Long id, UpdatePasswordDTO dto);
    void updateUsername(Long id, UpdateUsernameDTO dto);
    void delete(Long id);
    ClienteResponseDTO findById(Long id);
    List<ClienteResponseDTO> findAll();
    List<ClienteResponseDTO> findByEstado(String estado);
    List<UsuarioResponseDTO> findByCpf(String cpf);
    UsuarioResponseDTO login(String login, String senha);
}