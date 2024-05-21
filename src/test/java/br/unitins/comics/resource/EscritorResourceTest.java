package br.unitins.comics.resource;

import br.unitins.comics.dto.EscritorDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class EscritorResourceTest {

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/escritores")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByNomeTest() {
        given()
            .when()
            .get("/escritores/search/nome/Maria")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByCpfTest() {
        given()
            .when()
            .get("/escritores/search/cpf/987")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/escritores/1")
        .then()
            .statusCode(200);
    }

    @Test
    public void createTest() {
        EscritorDTO dto = new EscritorDTO(
            "Novo Escritor",
            "123.456.789-00",
            "novo.escritor@email.com"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/escritores")
        .then()
            .statusCode(201);
    }

    @Test
    public void updateTest() {
        EscritorDTO dto = new EscritorDTO(
            "Escritor Atualizado",
            "555.555.555-00",
            "escritor.atualizado@email.com"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/escritores/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest() {
        given()
            .pathParam("id", 2)
        .when()
            .delete("/escritores/{id}")
        .then()
            .statusCode(204);
    }
}
