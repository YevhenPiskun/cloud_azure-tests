package cloud.api;

import io.restassured.http.ContentType;
import org.entity.request.PizzaItem;
import org.entity.request.PizzasRequest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ReportsTests extends BaseApiTests {

    private static final String REPORTS = "/reports";

    @Test
    public void getReport() {

        String response = given().baseUri(GATEWAY_URL)
                .queryParam("subscription-key", KEY)
                .when()
                .log().all()
                .get(REPORTS)
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .asPrettyString();

        assertThat(response).contains("Pizzas", "Ingredients");
    }

    @Test
    public void publishReport() {

        PizzaItem pizzaItem1 = new PizzaItem();
        pizzaItem1.setIngredients(List.of("Mushrooms", "Ham", "Tomato"));
        pizzaItem1.setName("Neopolitano");

        PizzaItem pizzaItem2 = new PizzaItem();
        pizzaItem2.setIngredients(List.of("Cheeze", "Sausage", "Olive"));
        pizzaItem2.setName("Kerozo");

        PizzasRequest pizzasRequest = new PizzasRequest();
        pizzasRequest.setPizzas(List.of(pizzaItem1, pizzaItem2));


        String response = given().baseUri(GATEWAY_URL)
                .queryParam("subscription-key", KEY)
                .contentType(ContentType.JSON)
                .when()
                .body(pizzasRequest)
                .log().all()
                .post(REPORTS)
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.HTML)
                .extract()
                .response()
                .asPrettyString();

        assertThat(response).contains("Neopolitano", "Kerozo");
    }
}