package br.unitins.comics.resources;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;

import br.unitins.comics.dto.ClienteDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
public class ClienteResourceTest {
    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void createTest(){
        ClienteDTO dto = new ClienteDTO("Janete", 1L, 1l, "janete@email.com", "janete", "123");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/clientes")
        .then()
        .statusCode(201)
        .body("nome", is("Janete"));
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void findByIdTest(){
        given()
        .when()
        .get("/clientes/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void findByNomeTest(){
        given()
        .when()
        .get("/clientes/1")
        .then()
        .statusCode(200)
        .body("nome", is("Visao"));
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void updateTest(){
        ClienteDTO dto = new ClienteDTO("ROBERTO",8L,8L,"teresa@gmail.com","roberto","123");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/clientes/2")
        .then()
        .statusCode(204);
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void findAllTest(){
        given()
        .when()
        .get("/clientes")
        .then()
        .statusCode(200)
        .body("nome", hasItem(is("Visao")));;
    }

    @Test
    @TestSecurity(user = "tester", roles = "Funcionario")
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 4)
        .delete("/clientes/{id}")
        .then()
        .statusCode(204);
    }
    
}
