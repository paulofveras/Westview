package br.unitins.comics.resource;

import br.unitins.comics.dto.CategoriaDTO;
import br.unitins.comics.service.CategoriaService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CategoriaResourceTest {

    @Inject
    private CategoriaService categoriaService;

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/categorias/1")
        .then()
            .statusCode(200);
    }

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/categorias")
        .then()
            .statusCode(200);
    }

    @Test
    public void createTest() {
        CategoriaDTO dto = new CategoriaDTO("Marvel");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/categorias")
        .then()
            .statusCode(Status.CREATED.getStatusCode());
    }

    @Test
    public void updateTest() {
        CategoriaDTO dto = new CategoriaDTO("DC Comics");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/categorias/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void deleteTest() {
        given()
            .pathParam("id", 2)
        .when()
            .delete("/categorias/{id}")
        .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());
    }
}