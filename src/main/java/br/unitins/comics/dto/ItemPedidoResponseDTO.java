package br.unitins.comics.dto;

import br.unitins.comics.model.ItemPedido;

public record ItemPedidoResponseDTO (
    Long id,
    Double preco,
    Integer quantidade,
    Double desconto,
    QuadrinhoResponseDTO quadrinho
) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
        return new ItemPedidoResponseDTO(
            item.getId(), 
            item.getPreco(), 
            item.getQuantidade(),
            item.getDesconto(),
            QuadrinhoResponseDTO.valueOf(item.getQuadrinho()));
    }
}