// package br.unitins.comics.resource;

// import br.unitins.comics.dto.ArtistaCapaDTO;
// import io.quarkus.test.junit.QuarkusTest;
// import jakarta.ws.rs.core.MediaType;
// import org.junit.jupiter.api.Test;

// import static io.restassured.RestAssured.given;

// @QuarkusTest
// public class ArtistaCapaResourceTest {


//     @Test
//     public void findByIdTest() {
//         given()
//             .when()
//             .get("/artistasCapa/1")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void findAllTest() {
//         given()
//             .when()
//             .get("/artistasCapa")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void findByNomeTest() {
//         given()
//             .when()
//             .get("/artistasCapa/search/nome/Joao Silva")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void createTest() {
//         ArtistaCapaDTO dto = new ArtistaCapaDTO(
//             "Novo ArtistaCapa",
//             "123.456.789-00",
//             "novo.artista@email.com"
//         );

//         given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//         .when()
//             .post("/artistasCapa")
//         .then()
//             .statusCode(201);
//     }

//     @Test
//     public void updateTest() {
//         ArtistaCapaDTO dto = new ArtistaCapaDTO(
//             "ArtistaCapa Atualizado",
//             "987.654.321-00",
//             "artista.atualizado@email.com"
//         );

//         given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//         .when()
//             .pathParam("id", 2)
//             .put("/artistasCapa/{id}")
//         .then()
//             .statusCode(204);
//     }

//     @Test
//     public void deleteTest() {
//         given()
//             .pathParam("id", 2)
//         .when()
//             .delete("/artistasCapa/{id}")
//         .then()
//             .statusCode(204);
//     }
// }
