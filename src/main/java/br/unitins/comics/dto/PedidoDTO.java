package br.unitins.comics.dto;

import java.util.List;

public record PedidoDTO( 
    Long idCliente,
    Integer tipoPagamento,
    String nomeCartao,
    String numeroCartao,
    List<QuadrinhoPedidoDTO> quadrinhos
    ) {}
