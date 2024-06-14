package br.unitins.comics.resource;

import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.comics.dto.CategoriaDTO;

@QuarkusTest
public class CategoriaResourceTest {

    @Test
    public void testCreateCategoria() {
        CategoriaDTO dto = new CategoriaDTO("Universo Teste");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .post("/categorias")
            .then()
            .statusCode(201);
    }

    @Test
    public void testUpdateCategoria() {
        CategoriaDTO dto = new CategoriaDTO("Universo Atualizado");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .put("/categorias/1")
            .then()
            .statusCode(204);
        
        given()
            .when()
            .get("/categorias/1")
            .then()
            .statusCode(200);
    }

    @Test
    public void testDeleteCategoria() {
        given()
            .when()
            .delete("/categorias/2")
            .then()
            .statusCode(204);
    
    }

    @Test
    public void testFindCategoriaById() {
        given()
            .when()
            .get("/categorias/1")
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindAllCategorias() {
        given()
            .when()
            .get("/categorias")
            .then()
            .statusCode(200);
    }
}