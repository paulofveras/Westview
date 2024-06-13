package br.unitins.comics.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.comics.dto.GeneroDTO;
import br.unitins.comics.dto.GeneroResponseDTO;
import br.unitins.comics.service.GeneroService;
import jakarta.inject.Inject;
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
@Path("/generos")
public class GeneroResource {

    @Inject
    private GeneroService generoService;

    private static final Logger LOG = Logger.getLogger(QuadrinhoResource.class);

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        GeneroResponseDTO genero = generoService.findById(id);
        if (genero != null) {
            return Response.ok(genero).build();
        } else {
            LOG.infof("Executando o metodo findById. Id: %s", id.toString());
            return Response.status(Status.NOT_FOUND)
                    .entity("Gênero não encontrado.")
                    .build();
        }
    }

    @GET
    public Response findAll() {
        List<GeneroResponseDTO> generos = generoService.findAll();
        LOG.info("Executando o findAll");
        return Response.ok(generos).build();
    }

    @POST
    public Response create(GeneroDTO dto) {
        generoService.create(dto);
        LOG.info("Criando um genero de quadrinho");
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, GeneroDTO dto) {
        generoService.update(id, dto);
        LOG.info("Trocando o genero de um quadrinho");
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        generoService.delete(id);
        LOG.infof("Deletando. Id: %s", id.toString());
        return Response.status(Status.NO_CONTENT).build();
    }
}