package br.unitins.comics.resources;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;

import br.unitins.comics.dto.FuncionarioDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
public class FuncionarioResourceTest {
    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void createTest(){
        FuncionarioDTO dto = new FuncionarioDTO("Leandra","Vendedora",2L,2L,"leandra@gmail.com","lean","111");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/funcionarios")
        .then()
        .statusCode(201)
        .body("nome", is("Leandra"));
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void findByIdTest(){
        given()
        .when()
        .get("/funcionarios/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void findByNomeTest(){
        given()
        .when()
        .get("/funcionarios/1")
        .then()
        .statusCode(200)
        .body("nome", is("João"));
    }


    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void updateTest(){
        FuncionarioDTO dto = new FuncionarioDTO("Mário","Vendedora",1L,1L,"leandra@gmail.com","marcinho","333");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/funcionarios/1")
        .then()
        .statusCode(204);
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void findAllTest(){
        given()
        .when()
        .get("/funcionarios")
        .then()
        .statusCode(200)
        .body("nome", hasItem(is("Mário")));;
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 3)
        .delete("/funcionarios/{id}")
        .then()
        .statusCode(204);
    }
    
}
