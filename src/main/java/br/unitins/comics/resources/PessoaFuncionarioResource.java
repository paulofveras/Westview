package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.PessoaFuncionarioDTO;
import br.unitins.comics.model.PessoaFuncionario;
import br.unitins.comics.service.PessoaFuncionarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/pessoas/funcionarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaFuncionarioResource {
    @Inject
    private PessoaFuncionarioService pessoaFuncionarioService;

    @POST
    public Response criarPessoaFuncionario(@Valid PessoaFuncionarioDTO pessoaFuncionarioDTO) {
        PessoaFuncionario pessoaFuncionario = pessoaFuncionarioService.criarPessoaFuncionario(pessoaFuncionarioDTO);
        return Response.status(Status.CREATED).entity(pessoaFuncionario).build();
    }

    @GET
    public List<PessoaFuncionario> listarPessoasFuncionarios() {
        return pessoaFuncionarioService.listarPessoaFuncionarios();
    }

    @GET
    @Path("/{id}")
    public PessoaFuncionario buscarPessoaFuncionario(@PathParam("id") Long id) {
        return pessoaFuncionarioService.buscarPessoaFuncionario(id);
    }

    @PUT
    @Path("/{id}")
    public Response atualizarPessoaFuncionario(@PathParam("id") Long id, @Valid PessoaFuncionarioDTO pessoaFuncionarioDTO) {
        pessoaFuncionarioService.atualizarPessoaFuncionario(id, pessoaFuncionarioDTO);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirPessoaFuncionario(@PathParam("id") Long id) {
        pessoaFuncionarioService.excluirPessoaFuncionario(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
