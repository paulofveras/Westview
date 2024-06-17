package br.unitins.comics.dto;

import java.util.List;

public record PedidoDTO (
    Long idCliente,
    List<ItemPedidoDTO> itens,
    Integer idPagamento) 
{ }