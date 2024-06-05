package br.unitins.comics.resources;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.form.ImageForm;
import br.unitins.comics.service.QuadrinhoFileServiceImpl;
import br.unitins.comics.service.QuadrinhoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Path("/quadrinhos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuadrinhoResource {

    @Inject
    private QuadrinhoService quadrinhoService;

    @Inject
    public QuadrinhoFileServiceImpl fileService;

    private static final Logger LOG = Logger.getLogger(QuadrinhoResource.class);

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(quadrinhoService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
        LOG.info("Executando o findById");
        LOG.infof("Executando o método findById. Id: %s", Long.toString(0));
       return Response.ok(quadrinhoService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(quadrinhoService.findByNome(nome)).build();
    }

    @POST
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid QuadrinhoDTO dto) {
        LOG.info("INFO");
        LOG.warn("WARN");
        LOG.error("ERROR");
        LOG.fatal("FATAL");
        LOG.trace("TRACE");
        LOG.debugf("DTO: %s", dto);
        return Response.status(Status.CREATED).entity(quadrinhoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, QuadrinhoDTO dto) {
        quadrinhoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        quadrinhoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/{id}/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        fileService.salvar(id, form.getNomeImagem(), form.getImagem());
        return Response.noContent().build();
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build();
    }   
}
