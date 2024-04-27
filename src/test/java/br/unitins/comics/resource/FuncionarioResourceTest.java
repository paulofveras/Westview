package br.unitins.comics.resource;

import br.unitins.comics.dto.FuncionarioDTO;
import br.unitins.comics.service.FuncionarioService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class FuncionarioResourceTest {

    @Inject
    private FuncionarioService funcionarioService;

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/funcionarios")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByCargoTest() {
        given()
            .when()
            .get("/funcionarios/search/cargo/Gerente")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByCpfTest() {
        given()
            .when()
            .get("/funcionarios/search/cpf/123.456.789-00")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/funcionarios/1")
        .then()
            .statusCode(200);
    }

    @Test
    public void createTest() {
        FuncionarioDTO dto = new FuncionarioDTO(
            "Novo Funcionário",
            "123.456.789-00",
            "novo.funcionario@email.com",
            "Gerente"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/funcionarios")
        .then()
            .statusCode(Status.CREATED.getStatusCode());
    }

    @Test
    public void updateTest() {
        FuncionarioDTO dto = new FuncionarioDTO(
            "Funcionário Atualizado",
            "987.654.321-00",
            "funcionario.atualizado@email.com",
            "Atendente"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/funcionarios/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void deleteTest() {
        given()
            .pathParam("id", 2)
        .when()
            .delete("/funcionarios/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }
}
