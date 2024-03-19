package br.unitins.comics.resources;

import java.util.List;

import br.unitins.comics.dto.PessoaClienteDTO;
import br.unitins.comics.model.PessoaCliente;
import br.unitins.comics.service.PessoaClienteService;
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


@Path("/pessoas/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaClienteResource {
    
    @Inject
    private PessoaClienteService pessoaClienteService;

    @POST
    public Response criarPessoaCliente(@Valid PessoaClienteDTO pessoaClienteDTO) {
        PessoaCliente pessoaCliente = pessoaClienteService.criarPessoaCliente(pessoaClienteDTO);
        return Response.status(Status.CREATED).entity(pessoaCliente).build();
    }

    @GET
    public List<PessoaCliente> listarPessoasClientes() {
        return pessoaClienteService.listarPessoaClientes();
    }

    @GET
    @Path("/{id}")
    public PessoaCliente buscarPessoaCliente(@PathParam("id") Long id) {
        return pessoaClienteService.buscarPessoaCliente(id);
    }

    @PUT
    @Path("/{id}")
    public Response atualizarPessoaCliente(@PathParam("id") Long id, @Valid PessoaClienteDTO pessoaClienteDTO) {
        pessoaClienteService.atualizarPessoaCliente(id, pessoaClienteDTO);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirPessoaCliente(@PathParam("id") Long id) {
        pessoaClienteService.excluirPessoaCliente(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
