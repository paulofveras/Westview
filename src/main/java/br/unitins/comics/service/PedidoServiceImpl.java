package br.unitins.comics.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unitins.comics.dto.ItemPedidoDTO;
import br.unitins.comics.dto.PedidoDTO;
import br.unitins.comics.dto.PedidoResponseDTO;
import br.unitins.comics.model.ItemPedido;
import br.unitins.comics.model.Pedido;
import br.unitins.comics.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    public PedidoRepository pedidoRepository;

    // @Inject
    // public ConsultaRepository consultaRepository;

    // @Inject
    // public PacienteRepository pacienteRepository;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
       // pedido.setPaciente(pacienteRepository.findById(dto.idPaciente()));
        // total calculado
        List<ItemPedido> itens = new ArrayList<ItemPedido>();

        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();
            //item.setConsulta(consultaRepository.findById(itemDTO.idConsulta()));
            item.setDesconto(itemDTO.desconto());
            item.setPreco(itemDTO.preco());
            // adicionando na lista
            itens.add(item);

            // trabalhar o estoque de cada produto
        }

        pedido.setItens(itens);

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
    public List<PedidoResponseDTO> findByCliente(Long idPaciente) {
        return pedidoRepository.findByCliente(idPaciente).stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

}
