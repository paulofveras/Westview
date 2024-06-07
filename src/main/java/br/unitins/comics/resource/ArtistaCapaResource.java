package br.unitins.comics.resource;

import java.util.List;

import br.unitins.comics.dto.ArtistaCapaDTO;
import br.unitins.comics.dto.ArtistaCapaResponseDTO;
import br.unitins.comics.service.ArtistaCapaService;
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
@Path("/artistasCapa")
public class ArtistaCapaResource {

    @Inject
    private ArtistaCapaService artistaCapaService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        ArtistaCapaResponseDTO artistaCapa = artistaCapaService.findById(id);
        if (artistaCapa != null) {
            return Response.ok(artistaCapa).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("ArtistaCapa não encontrado.")
                    .build();
        }
    }

    @GET
    public Response findAll() {
        List<ArtistaCapaResponseDTO> artistasCapa = artistaCapaService.findAll();
        return Response.ok(artistasCapa).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        List<ArtistaCapaResponseDTO> artistasCapa = artistaCapaService.findByNome(nome);
        if (artistasCapa != null && !artistasCapa.isEmpty()) {
            return Response.ok(artistasCapa).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Nenhum ArtistaCapa encontrado com o nome fornecido.")
                    .build();
        }
    }

    @POST
    public Response create(ArtistaCapaDTO dto) {
        artistaCapaService.create(dto);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ArtistaCapaDTO dto) {
        artistaCapaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        artistaCapaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
