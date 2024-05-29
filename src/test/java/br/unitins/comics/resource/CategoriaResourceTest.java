// package br.unitins.comics.resource;

// import br.unitins.comics.dto.CategoriaDTO;
// import io.quarkus.test.junit.QuarkusTest;
// import jakarta.ws.rs.core.MediaType;
// import org.junit.jupiter.api.Test;

// import static io.restassured.RestAssured.given;

// @QuarkusTest
// public class CategoriaResourceTest {

//     @Test
//     public void findByIdTest() {
//         given()
//             .when()
//             .get("/categorias/1")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void findAllTest() {
//         given()
//             .when()
//             .get("/categorias")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void createTest() {
//         CategoriaDTO dto = new CategoriaDTO("Marvel");

//         given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//         .when()
//             .post("/categorias")
//         .then()
//             .statusCode(201);
//     }

//     @Test
//     public void updateTest() {
//         CategoriaDTO dto = new CategoriaDTO("DC Comics");

//         given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//         .when()
//             .pathParam("id", 2)
//             .put("/categorias/{id}")
//         .then()
//             .statusCode(204);
//     }

//     @Test
//     public void deleteTest() {
//         given()
//             .pathParam("id", 2)
//         .when()
//             .delete("/categorias/{id}")
//         .then()
//             .statusCode(204);
//     }
// }