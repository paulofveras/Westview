package br.unitins.comics.dto;

import java.util.List;

import br.unitins.comics.model.Pedido;

public record PedidoResponseDTO(
    Long id,
    ClienteResponseDTO cliente,
    Double total,
    List<QuadrinhoPedidoResponseDTO> quadrinhos 

) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        List<QuadrinhoPedidoResponseDTO> listaQuadrinhos = pedido.getQuadrinhos()
                                                            .stream()
                                                            .map(QuadrinhoPedidoResponseDTO::valueOf)
                                                            .toList();
        return new PedidoResponseDTO(
            pedido.getId(),
            ClienteResponseDTO.valueOf(pedido.getCliente()),
            pedido.getTotal(),
            listaQuadrinhos);
    }
}
