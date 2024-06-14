package br.unitins.comics.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.comics.dto.OrigemDTO;



import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class OrigemResourceTest {

    @Test
    public void testCreateOrigem() {
        OrigemDTO dto = new OrigemDTO("Brasil");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
        .when()
            .post("/origens")
        .then()
            .statusCode(201)
            .body("pais", equalTo("Brasil"));
    }

    @Test
    public void testUpdateOrigem() {
        OrigemDTO dto = new OrigemDTO("Argentina");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
        .when()
            .put("/origens/1")
        .then()
            .statusCode(204);

        given()
            .when()
            .get("/origens/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("pais", equalTo("Argentina"));
    }

    @Test
    public void testDeleteOrigem() {
        given()
            .when()
            .delete("/origens/1")
        .then()
            .statusCode(204);

        given()
            .when()
            .get("/origens/1")
        .then()
            .statusCode(404);
    }

    @Test
    public void testFindOrigemById() {
        given()
            .when()
            .get("/origens/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("pais", notNullValue());
    }

    @Test
    public void testFindAllOrigens() {
        given()
            .when()
            .get("/origens")
        .then()
            .statusCode(200)
            .body("size()", notNullValue());
    }
}
