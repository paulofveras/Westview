package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.model.Pessoa;
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

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    private PessoaService pessoaService;

    @GET
    public List<Pessoa> listarPessoas() {
        return pessoaService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarPessoa(@PathParam("id") Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        if (pessoa != null) {
            return Response.ok(pessoa).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Pessoa não encontrada.")
                    .build();
        }
    }

    @POST
    public Response criarPessoa(Pessoa pessoa) {
        pessoaService.create(pessoa);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarPessoa(@PathParam("id") Long id, Pessoa pessoa) {
        Pessoa existingPessoa = pessoaService.findById(id);
        if (existingPessoa != null) {
            pessoa.setId(id);
            pessoaService.update(pessoa);
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Pessoa não encontrada.")
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirPessoa(@PathParam("id") Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        if (pessoa != null) {
            pessoaService.delete(id);
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Pessoa não encontrada.")
                    .build();
        }
    }
}
