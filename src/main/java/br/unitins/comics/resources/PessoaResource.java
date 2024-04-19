package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.PessoaDTO;
import br.unitins.comics.dto.PessoaResponseDTO;
import br.unitins.comics.service.PessoaService;
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
@Path("/pessoas")
public class PessoaResource {

    @Inject
    private PessoaService pessoaService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        PessoaResponseDTO pessoa = pessoaService.findById(id);
        if (pessoa != null) {
            return Response.ok(pessoa).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Pessoa não encontrada.")
                    .build();
        }
    }

    @GET
    public Response findAll() {
        List<PessoaResponseDTO> pessoas = pessoaService.findAll();
        return Response.ok(pessoas).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        List<PessoaResponseDTO> pessoas = pessoaService.findByNome(nome);
        if (pessoas != null && !pessoas.isEmpty()) {
            return Response.ok(pessoas).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Nenhuma pessoa encontrada com o nome fornecido.")
                    .build();
        }
    }
    @POST
    public Response create(PessoaDTO dto) {
        pessoaService.create(dto);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PessoaDTO dto) {
        pessoaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        pessoaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}