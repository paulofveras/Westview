package br.unitins.comics.resource;

import br.unitins.comics.dto.GeneroDTO;
import br.unitins.comics.service.GeneroService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class GeneroResourceTest {

    @Inject
    private GeneroService generoService;

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
            .statusCode(Status.CREATED.getStatusCode());
    }

    @Test
    public void updateTest() {
        GeneroDTO dto = new GeneroDTO("Aventura", "Histórias de aventura");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/generos/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void deleteTest() {
        given()
            .pathParam("id", 2)
        .when()
            .delete("/generos/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }
}