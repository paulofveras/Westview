package br.unitins.comics.dto;

public record QuadrinhoPedidoDTO(
    Double preco,
    Double desconto,
    Integer quantidade,
    Long idQuadrinho
) {}
