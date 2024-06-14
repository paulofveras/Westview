package br.unitins.comics.resource;
 
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.comics.dto.GeneroDTO;

@QuarkusTest
public class GeneroResourceTest {

    @Test
    public void testCreateGenero() {
        GeneroDTO dto = new GeneroDTO("Aventura", "Gênero que envolve muitas ações e perigos.");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .post("/generos")
            .then()
            .statusCode(201);
    }

    @Test
    public void testUpdateGenero() {
        GeneroDTO dto = new GeneroDTO("Aventura Atualizada", "Descrição atualizada do gênero.");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .put("/generos/1")
            .then()
            .statusCode(204);
        
        given()
            .when()
            .get("/generos/1")
            .then()
            .statusCode(200)
            .body("genero", equalTo("Aventura Atualizada"))
            .body("descricao", equalTo("Descrição atualizada do gênero."));
    }

    @Test
    public void testDeleteGenero() {
        given()
            .when()
            .delete("/generos/1")
            .then()
            .statusCode(204);
        
        given()
            .when()
            .get("/generos/1")
            .then()
            .statusCode(404)
            .body(equalTo("Gênero não encontrado."));
    }

    @Test
    public void testFindGeneroById() {
        given()
            .when()
            .get("/generos/1")
            .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("genero", equalTo("Aventura"))
            .body("descricao", equalTo("Gênero que envolve muitas ações e perigos."));
    }

    @Test
    public void testFindAllGeneros() {
        given()
            .when()
            .get("/generos")
            .then()
            .statusCode(200)
            .body("size()", notNullValue());
    }
}