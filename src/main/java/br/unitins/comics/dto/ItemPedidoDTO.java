package br.unitins.comics.dto;

public record ItemPedidoDTO(
    Double preco,
    Double desconto,
    Integer quantidade,
    Long idQuadrinho
) {

}
