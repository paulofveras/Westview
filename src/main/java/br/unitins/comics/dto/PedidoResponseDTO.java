package br.unitins.comics.dto;

import java.util.List;

import br.unitins.comics.model.Pedido;

public record PedidoResponseDTO(
    Long id,
    ClienteResponseDTO cliente,
    Double total,
    List<ItemPedidoResponseDTO> itens
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        List<ItemPedidoResponseDTO> lista = pedido.getItens()
                                            .stream()
                                            .map(ItemPedidoResponseDTO::valueOf)
                                            .toList();
        return new PedidoResponseDTO(
            pedido.getId(), 
            ClienteResponseDTO.valueOf(pedido.getCliente()),
            pedido.getTotal(),
            lista);
    }

}
