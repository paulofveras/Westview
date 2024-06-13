// package br.unitins.comics.resource;

// import java.time.LocalDate;

// import org.junit.jupiter.api.Test;

// import br.unitins.comics.dto.QuadrinhoDTO;
// import io.quarkus.test.junit.QuarkusTest;
// import jakarta.ws.rs.core.MediaType;
// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.containsString;
// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.Matchers.everyItem;

// @QuarkusTest
// public class QuadrinhoResourceTest {

//     private final String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";

//     @Test
//     public void findAllTest() {
//         given()
//             .header("Authorization", "Bearer " + tokenAdm)
//         .when()
//             .get("/quadrinhos")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void findByIdTest() {
//         given()
//             .header("Authorization", "Bearer " + tokenAdm)
//         .when()
//             .get("/quadrinhos/1")
//         .then()
//             .statusCode(200)
//             .body("id", is(1));
//     }

//     @Test
//     public void findByNomeTest() {
//         given()
//             .header("Authorization", "Bearer " + tokenAdm)
//         .when()
//             .get("/quadrinhos/search/nome/Batman: O Cavaleiro das Trevas")
//         .then()
//             .statusCode(200)
//             .body("nome", everyItem(containsString("Batman: O Cavaleiro das Trevas")));
//     }

//     @Test
//     public void createTest() {
//         QuadrinhoDTO dto = new QuadrinhoDTO(
//             "Quadrinho Teste",
//             LocalDate.now(),
//             "Edição Teste",
//             19.99,
//             100,
//             1L, // ID da categoria
//             1L, // ID do escritor
//             1L, // ID do artista de capa
//             1, // ID da classificação
//             1L, // ID do gênero
//             1L // ID da origem
//         );

//         given()
//             .header("Authorization", "Bearer " + tokenAdm)
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//         .when()
//             .post("/quadrinhos")
//         .then()
//             .statusCode(201)
//             .body("nome", is("Quadrinho Teste"));
//     }

//     @Test
//     public void updateTest() {
//         QuadrinhoDTO dto = new QuadrinhoDTO(
//             "Quadrinho Atualizado",
//             LocalDate.now(),
//             "Edição Atualizada",
//             19.99,
//             100,
//             1L, // ID da categoria
//             1L, // ID do escritor
//             1L, // ID do artista de capa
//             1, // ID da classificação
//             1L, // ID do gênero
//             1L // ID da origem
//         );

//         given()
//             .header("Authorization", "Bearer " + tokenAdm)
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//         .when()
//             .pathParam("id", 1)
//             .put("/quadrinhos/{id}")
//         .then()
//             .statusCode(204);
//     }

//     @Test
//     public void deleteTest() {
//         given()
//             .header("Authorization", "Bearer " + tokenAdm)
//         .when()
//             .pathParam("id", 1)
//             .delete("/quadrinhos/{id}")
//         .then()
//             .statusCode(204);
//     }
// }