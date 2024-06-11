package br.unitins.comics.dto;

import java.util.List;

public record PedidoDTO( 
    Long idPaciente,
    List<ItemPedidoDTO> itens
    ) {}
