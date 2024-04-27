package br.unitins.comics.resource;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.comics.dto.CategoriaDTO;
import br.unitins.comics.dto.GeneroDTO;
import br.unitins.comics.dto.OrigemDTO;
import br.unitins.comics.dto.PessoaDTO;
import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;
import br.unitins.comics.model.Classificacao;
import br.unitins.comics.service.QuadrinhoService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response.Status;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;

@QuarkusTest
public class QuadrinhoResourceTest {

    @Inject
    private QuadrinhoService quadrinhoService;

    // @Test
    // public void findAllTest() {
    //     given()
    //         .when()
    //         .get("/quadrinhos")
    //     .then()
    //         .statusCode(200);
    // }

    // @Test
    // public void findByIdTest() {
    //     given()
    //         .when()
    //         .get("/quadrinhos/1")
    //     .then()
    //         .statusCode(200)
    //         .body("id", is(1));
    // }

    // @Test
    // public void findByNomeTest() {
        
    //     given()
    //         .when()
    //         .get("/quadrinhos/search/nome/Batman")
    //     .then()
    //         .statusCode(200)
    //         .body("nome", everyItem(containsString("Batman")));
    // }

    @Test
    public void createTest() {
        QuadrinhoDTO dto = new QuadrinhoDTO(
            "Quadrinho Teste",
            LocalDate.now(),
            "Edição Teste",
            19.99,
            100,
            1L, // ID da categoria
            List.of(1L, 2L), // IDs dos escritores
            List.of(1L, 2L), // IDs dos artistas de capa
            1, // ID da classificação
            1L, // ID do gênero
            1L // ID da origem
        );
    
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/quadrinhos")
        .then()
            .statusCode(201)
            .body("nome", is(dto.nome()))
            .body("quantidadeEstoque", is(dto.quantidadeEstoque()))
            .body("id_classificacao", is(dto.id_classificacao()))
            .body("genero", is(dto.genero()));
    }

    // @Test
    // public void updateTest() {
    //     QuadrinhoResponseDTO quadrinho = quadrinhoService.create(createQuadrinhoDTO());
    //     QuadrinhoDTO dto = createQuadrinhoDTO();
    //     given()
    //         .contentType(MediaType.APPLICATION_JSON)
    //         .body(dto)
    //     .when()
    //         .put("/quadrinhos/{id}", quadrinho.id())
    //     .then()
    //         .statusCode(204);
    // }

    // @Test
    // public void deleteTest() {
        
    //     given()
    //         .when()
    //         .pathParam("id", 4)
    //         .delete("/quadrinhos/{id}")
    //     .then()
    //         .statusCode(204);
    // }

}