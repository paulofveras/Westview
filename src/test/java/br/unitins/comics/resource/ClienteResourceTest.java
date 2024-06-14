package br.unitins.comics.resource;


import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import br.unitins.comics.dto.ClienteDTO;
import br.unitins.comics.dto.ClienteResponseDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;
import br.unitins.comics.service.ClienteService;


import java.time.LocalDate;
import java.util.Collections;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@QuarkusTest
public class ClienteResourceTest {

    @Mock
    ClienteService clienteService;

    @InjectMocks
    ClienteResource clienteResource;


    @Test
    public void testFindAll() {
        ClienteResponseDTO cliente = new ClienteResponseDTO(
                1L, "12345-678", "Rua Exemplo", "Estado Exemplo", "Cidade Exemplo",
                new UsuarioResponseDTO(1L, "Nome Exemplo", "username", "senha", LocalDate.now(), "email@example.com", "M", "123.456.789-00")
        );

        when(clienteService.findAll()).thenReturn(Collections.singletonList(cliente));

        given()
                .when().get("/clientes")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].id", is(1),
                        "[0].cep", is("12345-678"),
                        "[0].endereco", is("Rua Exemplo"),
                        "[0].estado", is("Estado Exemplo"),
                        "[0].cidade", is("Cidade Exemplo"));
    }

    @Test
    public void testCreate() {
        ClienteDTO clienteDTO = new ClienteDTO("12345-678", "Rua Exemplo", "Estado Exemplo", "Cidade Exemplo", "Nome Exemplo", "username", LocalDate.now(), "email@example.com", "senha", "123.456.789-00", "M");
        ClienteResponseDTO responseDTO = new ClienteResponseDTO(
                1L, "12345-678", "Rua Exemplo", "Estado Exemplo", "Cidade Exemplo",
                new UsuarioResponseDTO(1L, "Nome Exemplo", "username", "senha", LocalDate.now(), "email@example.com", "M", "123.456.789-00")
        );

        when(clienteService.create(any(ClienteDTO.class))).thenReturn(responseDTO);

        given()
                .contentType(ContentType.JSON)
                .body(clienteDTO)
                .when().post("/clientes")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .body("id", is(1),
                        "cep", is("12345-678"),
                        "endereco", is("Rua Exemplo"),
                        "estado", is("Estado Exemplo"),
                        "cidade", is("Cidade Exemplo"));
    }

    @Test
    public void testUpdate() {
        ClienteDTO clienteDTO = new ClienteDTO("12345-678", "Rua Atualizada", "Estado Atualizado", "Cidade Atualizada", "Nome Atualizado", "username", LocalDate.now(), "email@example.com", "senha", "123.456.789-00", "M");

        Mockito.doNothing().when(clienteService).update(any(Long.class), any(ClienteDTO.class));

        given()
                .contentType(ContentType.JSON)
                .body(clienteDTO)
                .when().put("/clientes/1")
                .then()
                .statusCode(Response.Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void testDelete() {
        Mockito.doNothing().when(clienteService).delete(any(Long.class));

        given()
                .when().delete("/clientes/1")
                .then()
                .statusCode(Response.Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void testFindById() {
        ClienteResponseDTO cliente = new ClienteResponseDTO(
                1L, "12345-678", "Rua Exemplo", "Estado Exemplo", "Cidade Exemplo",
                new UsuarioResponseDTO(1L, "Nome Exemplo", "username", "senha", LocalDate.now(), "email@example.com", "M", "123.456.789-00")
        );

        when(clienteService.findById(any(Long.class))).thenReturn(cliente);

        given()
                .when().get("/clientes/1")
                .then()
                .statusCode(200)
                .body("id", is(1),
                        "cep", is("12345-678"),
                        "endereco", is("Rua Exemplo"),
                        "estado", is("Estado Exemplo"),
                        "cidade", is("Cidade Exemplo"));
    }

    @Test
    public void testFindByEstado() {
        ClienteResponseDTO cliente = new ClienteResponseDTO(
                1L, "12345-678", "Rua Exemplo", "Estado Exemplo", "Cidade Exemplo",
                new UsuarioResponseDTO(1L, "Nome Exemplo", "username", "senha", LocalDate.now(), "email@example.com", "M", "123.456.789-00")
        );

        when(clienteService.findByEstado(any(String.class))).thenReturn(Collections.singletonList(cliente));

        given()
                .when().get("/clientes/search/estado/Estado Exemplo")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].id", is(1),
                        "[0].cep", is("12345-678"),
                        "[0].endereco", is("Rua Exemplo"),
                        "[0].estado", is("Estado Exemplo"),
                        "[0].cidade", is("Cidade Exemplo"));
    }

    @Test
    public void testFindByCpf() {
        UsuarioResponseDTO usuario = new UsuarioResponseDTO(1L, "Nome Exemplo", "username", "senha", LocalDate.now(), "email@example.com", "M", "123.456.789-00");

        when(clienteService.findByCpf(any(String.class))).thenReturn(Collections.singletonList(usuario));

        given()
                .when().get("/clientes/search/cpf/123.456.789-00")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].id", is(1),
                        "[0].nome", is("Nome Exemplo"),
                        "[0].username", is("username"),
                        "[0].senha", is("senha"),
                        "[0].dataNascimento", is(LocalDate.now().toString()),
                        "[0].email", is("email@example.com"),
                        "[0].genero", is("M"),
                        "[0].cpf", is("123.456.789-00"));
    }

    @Test
    public void testLogin() {
        UsuarioResponseDTO usuario = new UsuarioResponseDTO(1L, "Nome Exemplo", "username", "senha", LocalDate.now(), "email@example.com", "M", "123.456.789-00");

        when(clienteService.login(any(String.class), any(String.class))).thenReturn(usuario);

        given()
                .contentType(ContentType.JSON)
                .body("{\"username\": \"username\", \"senha\": \"senha\"}")
                .when().post("/clientes/login")
                .then()
                .statusCode(200)
                .body("id", is(1),
                        "nome", is("Nome Exemplo"),
                        "username", is("username"),
                        "senha", is("senha"),
                        "dataNascimento", is(LocalDate.now().toString()),
                        "email", is("email@example.com"),
                        "genero", is("M"),
                        "cpf", is("123.456.789-00"));
    }
}
