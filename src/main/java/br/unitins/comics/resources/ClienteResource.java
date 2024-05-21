package br.unitins.comics.resources;


import br.unitins.comics.dto.ClienteDTO;
import br.unitins.comics.service.ClienteService;
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
@Path("/clientes")
public class ClienteResource {

    @Inject
    public ClienteService clienteService;

    @GET
    public Response findAll() {
        return Response.ok(clienteService.findAll()).build();
    }

    @GET
    @Path("/search/estado/{estado}")
    public Response findByEstado(@PathParam("estado") String cargo) {
        return Response.ok(clienteService.findByEstado(cargo)).build();
    }

    @GET
    @Path("/search/cpf/{cpf}")
    public Response findByCpf(@PathParam("cpf") String cpf) {
        return Response.ok(clienteService.findByCpf(cpf)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(clienteService.findById(id)).build();
    }

    @POST
    public Response create(@Valid ClienteDTO dto) {
        return Response.status(Status.CREATED).entity(clienteService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        clienteService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        clienteService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
