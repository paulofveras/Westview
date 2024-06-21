package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.PedidoDTO;
import br.unitins.comics.dto.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {

    public PedidoResponseDTO create(@Valid PedidoDTO dto);
    public PedidoResponseDTO findById(Long id);
    public List<PedidoResponseDTO> findAll();
    public List<PedidoResponseDTO> findByCliente(Long idCliente);
    public void switchStatus(Long id);
    boolean clienteAutenticado(String username, Long idCliente);
    public List<PedidoResponseDTO> meusPedidos();
}