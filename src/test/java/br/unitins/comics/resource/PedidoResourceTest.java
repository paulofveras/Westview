package br.unitins.comics.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.comics.dto.ItemPedidoDTO;
import br.unitins.comics.dto.PedidoDTO;

import java.util.Arrays;
import java.util.List;

@QuarkusTest
public class PedidoResourceTest {

    @Test
    public void testCreatePedido() {
        List<ItemPedidoDTO> itens = Arrays.asList(
            new ItemPedidoDTO(10, 0.1, 1L)
        );
        PedidoDTO dto = new PedidoDTO(1L, itens, 1);

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .post("/pedidos")
            .then()
            .statusCode(200)
            .body("id", notNullValue())
            .body("cliente.id", equalTo(1))
            .body("itens.size()", equalTo(1))
            .body("itens[0].quantidade", equalTo(2))
            .body("pagamento.id", equalTo(1))
            .body("statusPagamento.id", equalTo(2)); // Assuming initial status is NAO_PAGO
    }

    @Test
    public void testFindAllPedidos() {
        given()
            .when()
            .get("/pedidos")
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindPedidoById() {
        Long id = 1L; // Assumindo que existe um pedido com ID 1 no banco de dados

        given()
            .when()
            .get("/pedidos/search/id/" + id)
            .then()
            .statusCode(200)
            .body("id", equalTo(id.intValue()));
    }

    @Test
    public void testFindPedidosByCliente() {
        Long idCliente = 1L; // Assumindo que existe um cliente com ID 1 que tem pedidos

        given()
            .when()
            .get("/pedidos/search/cliente/id/" + idCliente)
            .then()
            .statusCode(200)
            .body("[0].cliente.id", equalTo(idCliente.intValue()));
    }

    @Test
    public void testSwitchStatus() {
        Long id = 1L; // Assumindo que existe um pedido com ID 1 no banco de dados

        given()
            .when()
            .patch("/pedidos/switchStatus/" + id)
            .then()
            .statusCode(204);

        // Verificar se o status foi alterado
        given()
            .when()
            .get("/pedidos/search/id/" + id)
            .then()
            .statusCode(200)
            .body("statusPagamento.id", equalTo(1)); // Assuming the status was switched to PAGO
    }
}