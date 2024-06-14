package br.unitins.comics.resource;

import static io.restassured.RestAssured.given;
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
        ArtistaCapaDTO dto = new ArtistaCapaDTO("Wanda Maximoff");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .post("/artistas")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void testUpdateArtistaCapa() {
        ArtistaCapaDTO dto = new ArtistaCapaDTO("Updated Artista");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .put("/artistas/1")
            .then()
            .statusCode(204);
    
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void testDeleteArtistaCapa() {
        given()
            .when()
            .delete("/artistas/1")
            .then()
            .statusCode(204);
    
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindArtistaCapaById() {
        given()
            .when()
            .get("/artistas/1")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindAllArtistaCapas() {
        given()
            .when()
            .get("/artistas")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindArtistaCapasByNome() {
        given()
            .when()
            .get("/artistas/search/nome/Test Artista")
            .then()
            .statusCode(200);
    }
}
