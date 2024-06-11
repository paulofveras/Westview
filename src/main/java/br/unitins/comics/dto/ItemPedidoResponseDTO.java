package br.unitins.comics.dto;

import br.unitins.comics.model.ItemPedido;

public record ItemPedidoResponseDTO (
    Long id,
    String nome,
    Double desconto,
    Integer quantidade
) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
        return new ItemPedidoResponseDTO(
            item.getId(), 
            item.getQuadrinho().getNome(), 
            item.getDesconto(),
            item.getQuantidade());
    }
}
