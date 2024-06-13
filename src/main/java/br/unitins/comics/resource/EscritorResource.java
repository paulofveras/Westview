package br.unitins.comics.resource;

import org.jboss.logging.Logger;

import br.unitins.comics.dto.EscritorDTO;
import br.unitins.comics.service.EscritorService;
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
@Path("/escritores")
public class EscritorResource {

   @Inject
    public EscritorService escritorService;

    private static final Logger LOG = Logger.getLogger(QuadrinhoResource.class);

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(escritorService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(escritorService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.info("Executando o findByNome");
        return Response.ok(escritorService.findByNome(nome)).build();
    }

    @POST
    @RolesAllowed({"Funcionario"}) // Permite acesso apenas a funcionários
    public Response create(@Valid EscritorDTO dto) {
        LOG.info("Criando um escritor");
        return Response.status(Status.CREATED).entity(escritorService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"}) // Permite acesso apenas a funcionários
    public Response update(@PathParam("id") Long id, EscritorDTO dto) {
        escritorService.update(id, dto);
        LOG.info("Atualizando Escritor");
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"}) // Permite acesso apenas a funcionários
    public Response delete(@PathParam("id") Long id) {
        escritorService.delete(id);
        LOG.infof("Deletando o funcionário. Id: %s", id.toString());
        return Response.status(Status.NO_CONTENT).build();
    }
}
