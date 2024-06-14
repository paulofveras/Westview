 package br.unitins.comics.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.time.LocalDate;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.comics.dto.FuncionarioDTO;
import br.unitins.comics.dto.UpdatePasswordDTO;
import br.unitins.comics.dto.UpdateUsernameDTO;

@QuarkusTest
public class FuncionarioResourceTest {

    @Test
    public void testCreateFuncionario() {
        FuncionarioDTO dto = new FuncionarioDTO(
            5000.00, "Developer", "John Doe", "johndoe", 
            LocalDate.of(1990, 1, 1), "johndoe@example.com", 
            "password123", "12345678909", "Masculino");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .post("/funcionarios")
            .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("cargo", equalTo("Developer"))
            .body("salario", equalTo(5000.00F))
            .body("usuario.nome", equalTo("John Doe"))
            .body("usuario.username", equalTo("johndoe"))
            .body("usuario.email", equalTo("johndoe@example.com"));
    }

    @Test
    public void testFindAllFuncionarios() {
        given()
            .when()
            .get("/funcionarios")
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindFuncionarioById() {
        Long id = 1L; // Assumindo que existe um funcionário com ID 1 no banco de dados

        given()
            .when()
            .get("/funcionarios/" + id)
            .then()
            .statusCode(200)
            .body("id", equalTo(id.intValue()));
    }

    @Test
    public void testUpdateFuncionario() {
        Long id = 1L; // Assumindo que existe um funcionário com ID 1 no banco de dados
        FuncionarioDTO dto = new FuncionarioDTO(
            6000.00, "Senior Developer", "Jane Doe", "janedoe", 
            LocalDate.of(1985, 5, 15), "janedoe@example.com", 
            "newpassword123", "98765432100", "Feminino");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .put("/funcionarios/" + id)
            .then()
            .statusCode(204);
    }

    @Test
    public void testDeleteFuncionario() {
        Long id = 1L; // Assumindo que existe um funcionário com ID 1 no banco de dados

        given()
            .when()
            .delete("/funcionarios/" + id)
            .then()
            .statusCode(204);
    }

    @Test
    public void testFindByCargo() {
        String cargo = "Developer";

        given()
            .when()
            .get("/funcionarios/search/cargo/" + cargo)
            .then()
            .statusCode(200)
            .body("[0].cargo", equalTo(cargo));
    }

    @Test
    public void testFindByCpf() {
        String cpf = "12345678909"; // Assumindo que existe um funcionário com esse CPF no banco de dados

        given()
            .when()
            .get("/funcionarios/search/cpf/" + cpf)
            .then()
            .statusCode(200)
            .body("[0].usuario.cpf", equalTo(cpf));
    }

    @Test
    public void testUpdatePassword() {
        Long id = 1L; // Assumindo que existe um funcionário com ID 1 no banco de dados
        UpdatePasswordDTO dto = new UpdatePasswordDTO("oldpassword123", "newpassword123");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .patch("/funcionarios/update-password/" + id)
            .then()
            .statusCode(204);
    }

    @Test
    public void testUpdateUsername() {
        Long id = 1L; // Assumindo que existe um funcionário com ID 1 no banco de dados
        UpdateUsernameDTO dto = new UpdateUsernameDTO("newusername");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .patch("/funcionarios/update-username/" + id)
            .then()
            .statusCode(204);
    }
}