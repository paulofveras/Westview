package br.unitins.comics.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.not;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.comics.dto.ArtistaCapaDTO;

@QuarkusTest
public class ArtistaCapaResourceTest {

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void testCreateArtistaCapa() {
        ArtistaCapaDTO dto = new ArtistaCapaDTO("Test Artista");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .post("/autores")
            .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("nome", equalTo("Test Artista"));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void testUpdateArtistaCapa() {
        ArtistaCapaDTO dto = new ArtistaCapaDTO("Updated Artista");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .put("/autores/1")
            .then()
            .statusCode(204);
        
        given()
            .when()
            .get("/autores/1")
            .then()
            .statusCode(200)
            .body("nome", equalTo("Updated Artista"));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void testDeleteArtistaCapa() {
        given()
            .when()
            .delete("/autores/1")
            .then()
            .statusCode(204);
        
        given()
            .when()
            .get("/autores/1")
            .then()
            .statusCode(404);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindArtistaCapaById() {
        given()
            .when()
            .get("/autores/1")
            .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("nome", equalTo("Test Artista"));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindAllArtistaCapas() {
        given()
            .when()
            .get("/autores")
            .then()
            .statusCode(200)
            .body("size()", not(equalTo(0)));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindArtistaCapasByNome() {
        given()
            .when()
            .get("/autores/search/nome/Test Artista")
            .then()
            .statusCode(200)
            .body("size()", not(equalTo(0)))
            .body("[0].nome", equalTo("Test Artista"));
    }
}
