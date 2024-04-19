package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.EscritorDTO;
import br.unitins.comics.dto.EscritorResponseDTO;
import br.unitins.comics.service.EscritorService;
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
@Path("/escritores")
public class EscritorResource {

    @Inject
    private EscritorService escritorService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        EscritorResponseDTO escritor = escritorService.findById(id);
        if (escritor != null) {
            return Response.ok(escritor).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Escritor não encontrado.")
                    .build();
        }
    }

    @GET
    public Response findAll() {
        List<EscritorResponseDTO> escritores = escritorService.findAll();
        return Response.ok(escritores).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        List<EscritorResponseDTO> escritores = escritorService.findByNome(nome);
        if (escritores != null && !escritores.isEmpty()) {
            return Response.ok(escritores).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Nenhum Escritor encontrado com o nome fornecido.")
                    .build();
        }
    }

    @POST
    public Response create(EscritorDTO dto) {
        escritorService.create(dto);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EscritorDTO dto) {
        escritorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        escritorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
