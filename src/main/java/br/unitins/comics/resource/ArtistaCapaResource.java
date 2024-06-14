package br.unitins.comics.resource;

import org.jboss.logging.Logger;

import br.unitins.comics.dto.ArtistaCapaDTO;
import br.unitins.comics.service.ArtistaCapaService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
@Path("/artistas")
public class ArtistaCapaResource {

    @Inject
    public ArtistaCapaService artistaCapaService;

    private static final Logger LOG = Logger.getLogger(QuadrinhoResource.class);

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(artistaCapaService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(artistaCapaService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.info("Executando o findByNome");
        return Response.ok(artistaCapaService.findByNome(nome)).build();
    }

    @POST
    @RolesAllowed({"Funcionario"}) // Permite acesso apenas a funcionários
    public Response create(@Valid ArtistaCapaDTO dto) {
        LOG.info("Criando um Artista de Capas de Quadrinhos");
        return Response.status(Status.CREATED).entity(artistaCapaService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"}) // Permite acesso apenas a funcionários
    public Response update(@PathParam("id") Long id, ArtistaCapaDTO dto) {
        LOG.info("Atualizando um Artista de Capas.");
        artistaCapaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"}) // Permite acesso apenas a funcionários
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando o artista da capa. Id: %s", id.toString());
        artistaCapaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
