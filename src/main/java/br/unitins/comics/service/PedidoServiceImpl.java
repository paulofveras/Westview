package br.unitins.comics.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.comics.dto.ItemPedidoDTO;
import br.unitins.comics.dto.PedidoDTO;
import br.unitins.comics.dto.PedidoResponseDTO;
import br.unitins.comics.model.Quadrinho;
import br.unitins.comics.model.Cliente;
import br.unitins.comics.model.ItemPedido;
import br.unitins.comics.model.Pagamento;
import br.unitins.comics.model.Pedido;
import br.unitins.comics.model.Status;
import br.unitins.comics.repository.QuadrinhoRepository;
import br.unitins.comics.repository.ClienteRepository;
import br.unitins.comics.repository.PedidoRepository;
import br.unitins.comics.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    public PedidoRepository pedidoRepository;

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    QuadrinhoRepository quadrinhoRepository;

    @Inject
    JsonWebToken tokenJwt;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setCliente(clienteRepository.findById(dto.idCliente()));
        pedido.setTotal(0d);
        pedido.setFormaPagamento(Pagamento.valueOf(dto.idPagamento()));

        List<ItemPedido> itens = new ArrayList<ItemPedido>();

        for (ItemPedidoDTO itemDTO : dto.itens()) {

            Quadrinho quadrinho = quadrinhoRepository.findById(itemDTO.idQuadrinho());

            ItemPedido item = new ItemPedido();
           
            item.setDesconto(itemDTO.desconto());
            item.setQuantidade(itemDTO.quantidade());

            Double precoDesconto = Double.valueOf(quadrinho.getPreco() * item.getQuantidade())-((itemDTO.desconto()/100) * Double.valueOf(quadrinho.getPreco() * item.getQuantidade()));

            item.setPreco(precoDesconto);
            item.setQuadrinho(quadrinho);

            pedido.setTotal(pedido.getTotal() + item.getPreco());

            // trabalhar o estoque de cada produto
            if(itemDTO.quantidade() <= quadrinho.getEstoque()){
                // adicionando na lista
                itens.add(item);
                
                quadrinho.setEstoque(quadrinho.getEstoque() - itemDTO.quantidade());
                quadrinhoRepository.persist(quadrinho);
            } else {
                throw new ValidationException("Pedido não finalizado", "Estoque insuficiente do produto: "+quadrinho.getNome());
            }
           
            
        }
        pedido.setItens(itens);
        pedido.setStatusPagamento(Status.NAO_PAGO);

        

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null)
            return PedidoResponseDTO.valueOf(pedido);
        return null;
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        return pedidoRepository
        .listAll()
        .stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        return pedidoRepository.findByCliente(idCliente)
                .stream()
                .map(PedidoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void switchStatus(Long id){
        Pedido pedido = pedidoRepository.findById(id);

        if(pedido != null){
            
            if(pedido.getStatusPagamento() == Status.PAGO){
                pedido.setStatusPagamento(Status.NAO_PAGO);
            } else if (pedido.getStatusPagamento() == Status.NAO_PAGO){
                pedido.setStatusPagamento(Status.PAGO);
            }

        } else {
            throw new BadRequestException("Pedido não encontrado");
        }

       
        
    }

     public boolean clienteAutenticado(String username, Long idCliente){
        Cliente clienteAutenticado = clienteRepository.findByUsername(username);
        return clienteAutenticado != null && clienteAutenticado.getId().equals(idCliente);
    }

    @Override
    @Transactional
    public List<PedidoResponseDTO> meusPedidos(){
        String username = tokenJwt.getName();
        List<PedidoResponseDTO> pedidos = pedidoRepository.find("cliente.usuario.username", username).stream().map(e -> PedidoResponseDTO.valueOf(e)).toList();
        
        if(pedidos.isEmpty()){
            throw new ValidationException("Meus pedidos","Você ainda não fez nenhum pedido.");
        }

        return pedidos;
    }

}