package br.unitins.comics.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unitins.comics.dto.PedidoDTO;
import br.unitins.comics.dto.PedidoResponseDTO;
import br.unitins.comics.dto.QuadrinhoPedidoDTO;
import br.unitins.comics.model.Pedido;
import br.unitins.comics.model.QuadrinhoPedido;
import br.unitins.comics.repository.ClienteRepository;
import br.unitins.comics.repository.PedidoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

public class PedidoServiceImpl implements PedidoService{
    @Inject
    public PedidoRepository pedidoRepository;

    @Inject
    public ClienteRepository clienteRepository;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {

        Pedido pedido = new Pedido();
        double total =0;
        pedido.setData(LocalDateTime.now());
        pedido.setCliente(clienteRepository.findById(dto.idCliente()));

        List<QuadrinhoPedido> quadrinho = new ArrayList<QuadrinhoPedido>();
        for(QuadrinhoPedidoDTO quadrinhoDTO : dto.quadrinhos()) {
            QuadrinhoPedido quadrinhoPedido = new QuadrinhoPedido();
            quadrinhoPedido.setDesconto(quadrinhoDTO.desconto());
            quadrinhoPedido.setPreco(quadrinhoDTO.preco());
            total += quadrinhoDTO.preco();
            quadrinho.add(quadrinhoPedido);
        }

        pedido.setTotal(total);
        pedido.setQuadrinhos(quadrinho);

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
        
    }    
    
    @Override
    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null)
            return PedidoResponseDTO.valueOf(pedido);
        return null;
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        return pedidoRepository
        .listAll()
        .stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        return pedidoRepository.findByCliente(idCliente).stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }
}
