package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ClienteDTO;
import br.unitins.comics.dto.ClienteResponseDTO;
import br.unitins.comics.dto.ClienteUpdatePasswordDTO;
import br.unitins.comics.dto.ClienteUpdateUsernameDTO;
import br.unitins.comics.dto.UpdatePasswordDTO;
import br.unitins.comics.dto.UpdateUsernameDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface ClienteService {
    public ClienteResponseDTO create(@Valid ClienteDTO dto);
    public void update(Long id, ClienteDTO dto);
    public void updatePassword(Long id, UpdatePasswordDTO dto);
    public void updateUsername(Long id, UpdateUsernameDTO dto);
    public void delete(Long id);
    public ClienteResponseDTO findById(Long id);
    public List<ClienteResponseDTO> findAll();
    public List<ClienteResponseDTO> findByEstado(String estado);
    public List<UsuarioResponseDTO> findByCpf(String cpf);
    public UsuarioResponseDTO login(String login, String senha);
}