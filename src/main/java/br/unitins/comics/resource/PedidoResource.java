package br.unitins.comics.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import br.unitins.comics.dto.PedidoDTO;
import br.unitins.comics.model.Cliente;
import br.unitins.comics.repository.ClienteRepository;
import br.unitins.comics.service.ClienteService;
import br.unitins.comics.service.PedidoService;
import br.unitins.comics.validation.ValidationException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.PathParam;
    
@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    public PedidoService service;

    @Inject
    public ClienteService clienteservice;

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    JsonWebToken tokenJwt;
    
    private static final Logger LOG = Logger.getLogger(EnderecoResource.class);

    @POST
    @RolesAllowed("Cliente")
    public Response create(PedidoDTO dto){
        LOG.info("Criando um pedido");
        return Response.ok(service.create(dto)).build();
    }

    @PATCH
    @RolesAllowed("Funcionario")
    @Path("/switchStatus/{id}")
    public Response switchStatus( @PathParam("id") Long id){
        LOG.info("Trocando o status de pagamento do pedido");
        service.switchStatus(id);
        return Response.noContent().build(); 
    }

    @GET
    
    @RolesAllowed("Funcionario")
    public Response findAll(){
        LOG.info("Executando o findAll");
        return Response.ok(service.findAll()).build();
    }

    @GET
    @RolesAllowed("Funcionario")
    @Path("/search/id/{id}")
    public Response findById( @PathParam("id") Long id){
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @RolesAllowed("Funcionario")
    @Path("/search/cliente/id/{id_cliente}")
    public Response findByCliente( @PathParam("id_cliente") Long idCliente ){
        LOG.info("Executando o metodo findByCliente");
        return Response.ok(service.findByCliente(idCliente)).build();
    }

    @GET
    @Path("/search/meus-Pedidos")
    @RolesAllowed({"Funcionario","Cliente"})
    public Response meusPedidos(){
        try {
            LOG.info("Meus pedidos.");
            String username = tokenJwt.getName();
            Cliente cliente = clienteRepository.findByUsername(username);

            if(!service.clienteAutenticado(username, cliente.getId()))
                throw new ValidationException("Validando cliente para visualiar pedidos", "Você não tem permissão para vê os pedidos");

            return Response.ok(service.meusPedidos()).build();
        } catch (NotFoundException e) {
            LOG.error("Erro ao visualizar meus pedidos", e);
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

}