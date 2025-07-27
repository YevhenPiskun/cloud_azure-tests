package cloud.api;

import io.restassured.http.ContentType;
import org.entity.request.IngredientItem;
import org.entity.request.IngredientsRequest;
import org.entity.response.PriceResponse;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class TotalPriceTests extends BaseApiTests {

    private static final String PRICING = "/pricing/api/GetPrice";

    @Test
    public void getTotalPriceTest() {

        String response = given().baseUri(GATEWAY_URL)
                .queryParam("subscription-key", KEY)
                .when()
                .log().all()
                .get(PRICING)
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .extract()
                .response()
                .asPrettyString();

        assertThat(response).contains("TotalPrice", "Price", "Tax", "TaxRate", "Ingredients");
    }

    @Test
    public void postTotalPriceTest() {

        IngredientsRequest ingredientsRequest = new IngredientsRequest();

        IngredientItem ingredientItem1 = new IngredientItem();
        ingredientItem1.setName("Tomato");
        ingredientItem1.setQuantity(6);
        ingredientItem1.setPrice(10);

        IngredientItem ingredientItem2 = new IngredientItem();
        ingredientItem2.setName("Cheese");
        ingredientItem2.setQuantity(1);
        ingredientItem2.setPrice(2);

        ingredientsRequest.setIngredients(List.of(ingredientItem1, ingredientItem2));
        ingredientsRequest.setRegion("Aurelia");

        PriceResponse response = given().baseUri(GATEWAY_URL)
                .contentType(ContentType.JSON)
                .queryParam("subscription-key", KEY)
                .body(ingredientsRequest)
                .when()
                .log().all()
                .post(PRICING)
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(PriceResponse.class);

        assertThat(response.getIngredients().get(0).getName()).isEqualTo(ingredientItem1.getName());
        assertThat(response.getIngredients().get(0).getQuantity()).isEqualTo(ingredientItem1.getQuantity());
        assertThat(response.getIngredients().get(1).getName()).isEqualTo(ingredientItem2.getName());
        assertThat(response.getIngredients().get(1).getQuantity()).isEqualTo(ingredientItem2.getQuantity());
    }
}