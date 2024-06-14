 package br.unitins.comics.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.not;

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
            .statusCode(201)
            .body("id", notNullValue())
            .body("nome", equalTo("Test Escritor"));
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
            .statusCode(200)
            .body("nome", equalTo("Updated Escritor"));
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
            .statusCode(200)
            .body("id", equalTo(1))
            .body("nome", equalTo("Test Escritor"));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindAllEscritores() {
        given()
            .when()
            .get("/escritores")
            .then()
            .statusCode(200)
            .body("size()", not(equalTo(0)));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario", "Cliente"})
    public void testFindEscritoresByNome() {
        given()
            .when()
            .get("/escritores/search/nome/Test Escritor")
            .then()
            .statusCode(200)
            .body("size()", not(equalTo(0)))
            .body("[0].nome", equalTo("Test Escritor"));
    }
}
