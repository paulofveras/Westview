// package br.unitins.comics.resource;

// import br.unitins.comics.dto.ClienteDTO;
// import io.quarkus.test.junit.QuarkusTest;
// import jakarta.ws.rs.core.MediaType;
// import static org.hamcrest.CoreMatchers.containsString;
// import static org.hamcrest.CoreMatchers.everyItem;

// import org.junit.jupiter.api.Test;
// import static io.restassured.RestAssured.given;


// @QuarkusTest
// public class ClienteResourceTest {

//     @Test
//     public void findAllTest() {
//         given()
//             .when()
//             .get("/clientes")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void findByEstadoTest() {
//         given()
//             .when()
//             .get("/clientes/search/estado/Sao")
//         .then()
//             .statusCode(200)
//             .body("estado", everyItem(containsString("Paulo")));
//     }

//     @Test
//     public void findByCpfTest() {
//         given()
//             .when()
//             .get("/clientes/search/cpf/123.456.789-00")
//         .then()
//             .statusCode(200)
//             .body("cpf", everyItem(containsString("123")));
//     }

//     @Test
//     public void findByIdTest() {
//         given()
//             .when()
//             .get("/clientes/1")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void createTest() {
//         ClienteDTO dto = new ClienteDTO(
//             "São Paulo",
//             "São Paulo",
//             "Novo Cliente",
//             "123.456.789-00",
//             "novo.cliente@email.com",
//             "cliente123",
//             "senha123"
//         );

//         given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//         .when()
//             .post("/clientes")
//         .then()
//             .statusCode(201);
//     }

//     @Test
//     public void updateTest() {
//         ClienteDTO dto = new ClienteDTO(
//             "Rio de Janeiro",
//             "RJ",
//             "Cliente Atualizado",
//             "987.654.321-00",
//             "cliente.atualizado@email.com",
//             "cliente123",
//             "senha123"
//         );

//         given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//         .when()
//             .pathParam("id", 1)
//             .put("/clientes/{id}")
//         .then()
//             .statusCode(204);
//     }

//     @Test
//     public void deleteTest() {
//         given()
//             .pathParam("id", 1)
//         .when()
//             .delete("/clientes/{id}")
//         .then()
//             .statusCode(204);
//     }
// }
