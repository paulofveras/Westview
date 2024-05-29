package br.unitins.comics.dto;

import br.unitins.comics.model.QuadrinhoPedido;

public record QuadrinhoPedidoResponseDTO(Long id,
String nome,
Double desconto,
Integer quantidade
) {
public static QuadrinhoPedidoResponseDTO valueOf(QuadrinhoPedido item) {
    return new QuadrinhoPedidoResponseDTO(
        item.getId(), 
        item.getQuadrinho().getNome(), 
        item.getDesconto(),
        item.getQuantidade());
}
}
