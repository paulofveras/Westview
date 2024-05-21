package br.unitins.comics.resource;

import br.unitins.comics.dto.FuncionarioDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response.Status;


import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class FuncionarioResourceTest {

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
            .statusCode(200)
            .body("cargo", everyItem(containsStringIgnoringCase("gerente") ));
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
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void createTest() {
        FuncionarioDTO dto = new FuncionarioDTO(
            "Gerente",
            "Novo Funcionario",
            "123.456.789-00",
            "novo.funcionario@email.com",
            "Funcionario",
            "funcionario123"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/funcionarios")
        .then()
            .statusCode(201)
            .body("cargo", is("Gerente"));
    }

    @Test
    public void updateTest() {
        FuncionarioDTO dto = new FuncionarioDTO(
            "Gerente",
            "Novo Funcionario Atualizado",
            "123.456.789-00",
            "novo.funcionario@email.com",
            "Funcionario",
            "funcionario123"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/funcionarios/{id}")
        .then()
            .statusCode(204);
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
