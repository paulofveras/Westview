package br.unitins.comics.resource;

import br.unitins.comics.dto.OrigemDTO;
import br.unitins.comics.service.OrigemService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class OrigemResourceTest {

    @Inject
    private OrigemService origemService;

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
            .statusCode(Status.CREATED.getStatusCode());
    }

    @Test
    public void updateTest() {
        OrigemDTO dto = new OrigemDTO("Brasil");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/origens/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void deleteTest() {
        given()
            .pathParam("id", 2)
        .when()
            .delete("/origens/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }
}
