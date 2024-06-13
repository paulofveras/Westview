package br.unitins.comics.resource;

import org.jboss.logging.Logger;

import br.unitins.comics.dto.OrigemDTO;
import br.unitins.comics.service.OrigemService;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/origens")
public class OrigemResource {

    @Inject
    private OrigemService origemService;

    private static final Logger LOG = Logger.getLogger(QuadrinhoResource.class);

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(origemService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(origemService.findAll()).build();
    }

    @POST
    public Response create(OrigemDTO dto) {
        LOG.info("Criando um país");
        return Response.status(Status.CREATED).entity(origemService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, OrigemDTO dto) {
        LOG.info("Trocando a origem");
        origemService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        try {
            origemService.delete(id);
            LOG.infof("Deletando origem. Id: %s", id.toString());
            return Response.status(Status.NO_CONTENT).build();
        } catch (PersistenceException e) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Não é possível excluir a origem devido a registros dependentes.").build();
        }
    }
}