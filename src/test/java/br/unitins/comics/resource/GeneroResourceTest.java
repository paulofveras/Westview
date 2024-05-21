package br.unitins.comics.resource;

import br.unitins.comics.dto.GeneroDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class GeneroResourceTest {

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/generos/1")
        .then()
            .statusCode(200);
    }

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/generos")
        .then()
            .statusCode(200);
    }

    @Test
    public void createTest() {
        GeneroDTO dto = new GeneroDTO("Ação", "Histórias de ação");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/generos")
        .then()
            .statusCode(201);
    }

    @Test
    public void updateTest() {
        GeneroDTO dto = new GeneroDTO("Aventura", "Histórias de aventura");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/generos/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest() {
        given()
            .pathParam("id", 2)
        .when()
            .delete("/generos/{id}")
        .then()
            .statusCode(204);
    }
}