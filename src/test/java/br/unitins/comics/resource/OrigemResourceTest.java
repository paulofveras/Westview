package br.unitins.comics.resource;

import br.unitins.comics.dto.OrigemDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class OrigemResourceTest {

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/origens/1")
        .then()
            .statusCode(200);
    }

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/origens")
        .then()
            .statusCode(200);
    }

    @Test
    public void createTest() {
        OrigemDTO dto = new OrigemDTO("Estados Unidos");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/origens")
        .then()
            .statusCode(201);
    }

    @Test
    public void updateTest() {
        OrigemDTO dto = new OrigemDTO("Brasil");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/origens/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest() {
        given()
            .pathParam("id", 2)
        .when()
            .delete("/origens/{id}")
        .then()
            .statusCode(204);
    }
}
