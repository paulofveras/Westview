package br.unitins.comics.resources;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;

import br.unitins.comics.dto.QuadrinhoDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
public class QuadrinhoResourceTest {
    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void createTest(){
        QuadrinhoDTO dto = new QuadrinhoDTO("Antman", "Descrição", 12.50f, 150, 2, 1L, 50);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/quadrinhos")
        .then()
        .statusCode(201)
        .body("nome", is("Antman"));
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void findByIdTest(){
        given()
        .when()
        .get("/quadrinhos/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void findByNomeTest(){
        given()
        .when()
        .get("/quadrinhos/1")
        .then()
        .statusCode(200)
        .body("nome", is("Secret Wars"));
    }


    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void updateTest(){
        QuadrinhoDTO dto = new QuadrinhoDTO("X-Men Vol. 61", "Um quadrinho muito chique", 20f, 210, 1, 2L, 20);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/quadrinhos/2")
        .then()
        .statusCode(204);
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void findAllTest(){
        given()
        .when()
        .get("/quadrinhos")
        .then()
        .statusCode(200)
        .body("nome", hasItem(is("Secret Wars")));;
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 3)
        .delete("/quadrinhos/{id}")
        .then()
        .statusCode(204);
    }
    
}
