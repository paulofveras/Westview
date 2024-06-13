package br.unitins.comics.resource;

import org.jboss.logging.Logger;

import br.unitins.comics.dto.PedidoDTO;
import br.unitins.comics.service.PedidoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pedidos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    public PedidoService service;

    private static final Logger LOG = Logger.getLogger(QuadrinhoResource.class);

    @POST
    public Response create(PedidoDTO dto){
        LOG.info("Criando um pedido");
        return Response.ok(service.create(dto)).build();
    }

    @PATCH
    @Path("/switchStatus/{id}")
    public Response switchStatus( @PathParam("id") Long id){
        LOG.info("Trocando o status de pagamento do pedido");
        service.switchStatus(id);
        return Response.noContent().build(); 
    }

    @GET
    public Response findAll(){
        LOG.info("Executando o findAll");
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/search/id/{id}")
    public Response findById( @PathParam("id") Long id){
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/cliente/id/{id}")
    public Response findByCliente( @PathParam("idCliente") Long idCliente ){
        LOG.info("Executando o metodo findByCliente");
        return Response.ok(service.findByCliente(idCliente)).build();
    }
}
