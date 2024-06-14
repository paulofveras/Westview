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

        @Test
        public void testCreateCliente() {
            ClienteDTO clienteDTO = new ClienteDTO("12345-678", "Rua Exemplo", "Estado Exemplo", "Cidade Exemplo", 
                                                   "Nome Exemplo", "username", LocalDate.of(1999, 9, 12), "email@example.com", 
                                                   "senha", "123.456.789-00", "M");
        
            given()
                .contentType(ContentType.JSON)
                .body(clienteDTO)
                .when()
                .post("/clientes")
                .then()
                .statusCode(201);
        }

    @Test
    public void testUpdateCliente() {
        ClienteDTO clienteDTO = new ClienteDTO("12345-678", "Rua Atualizada", "Estado Atualizado", "Cidade Atualizada", 
                                               "Nome Atualizado", "username", LocalDate.now(), "email@example.com", 
                                               "senha", "123.456.789-00", "M");

        given()
            .contentType(ContentType.JSON)
            .body(clienteDTO)
            .when()
            .put("/clientes/1")
            .then()
            .statusCode(204);
    }

    @Test
    public void testDeleteCliente() {
        given()
            .when()
            .delete("/clientes/2")
            .then()
            .statusCode(204);
    }

    @Test
    public void testFindClienteById() {
        given()
            .when()
            .get("/clientes/2")
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindAllClientes() {
        given()
            .when()
            .get("/clientes")
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindByEstado() {
        given()
            .when()
            .get("/clientes/search/estado/Estado Exemplo")
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindByCpf() {
        given()
            .when()
            .get("/clientes/search/cpf/123.456.789-00")
            .then()
            .statusCode(200);
    }

    @Test
    public void testLogin() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"username\": \"username\", \"senha\": \"senha\"}")
            .when()
            .post("/clientes/login")
            .then()
            .statusCode(200);
    }
}
