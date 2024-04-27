package br.unitins.comics.resource;

import br.unitins.comics.dto.ClienteDTO;
import br.unitins.comics.model.Cliente;
import br.unitins.comics.service.ClienteService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ClienteResourceTest {

    @Inject
    private ClienteService clienteService;

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/clientes")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByCargoTest() {
        given()
            .when()
            .get("/clientes/search/estado/São Paulo")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByCpfTest() {
        given()
            .when()
            .get("/clientes/search/cpf/123.456.789-00")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/clientes/1")
        .then()
            .statusCode(200);
    }

    @Test
    public void createTest() {
        ClienteDTO dto = new ClienteDTO(
            "Novo Cliente",
            "123.456.789-00",
            "novo.cliente@email.com",
            "São Paulo",
            "São Paulo"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/clientes")
        .then()
            .statusCode(Status.CREATED.getStatusCode());
    }

    @Test
    public void updateTest() {
        ClienteDTO dto = new ClienteDTO(
            "Cliente Atualizado",
            "987.654.321-00",
            "cliente.atualizado@email.com",
            "Rio de Janeiro",
            "RJ"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/clientes/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void deleteTest() {
        given()
            .pathParam("id", 2)
        .when()
            .delete("/clientes/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }
}
