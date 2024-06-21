package br.unitins.comics.dto;

public record ItemPedidoDTO(
    Integer quantidade,
    Double desconto,
    Long idQuadrinho
) {

}