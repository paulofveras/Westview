 package br.unitins.comics.resource;

import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.comics.dto.EscritorDTO;

@QuarkusTest
public class EscritorResourceTest {

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void testCreateEscritor() {
        EscritorDTO dto = new EscritorDTO("Test Escritor");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .post("/escritores")
            .then()
            .statusCode(201);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void testUpdateEscritor() {
        EscritorDTO dto = new EscritorDTO("Updated Escritor");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .put("/escritores/1")
            .then()
            .statusCode(204);
        
        given()
            .when()
            .get("/escritores/1")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void testDeleteEscritor() {
        given()
            .when()
            .delete("/escritores/1")
            .then()
            .statusCode(204);
        
        given()
            .when()
            .get("/escritores/1")
            .then()
            .statusCode(404);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindEscritorById() {
        given()
            .when()
            .get("/escritores/1")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindAllEscritores() {
        given()
            .when()
            .get("/escritores")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindEscritoresByNome() {
        given()
            .when()
            .get("/escritores/search/nome/Test Escritor")
            .then()
            .statusCode(200);
    }
}
