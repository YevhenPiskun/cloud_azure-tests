package cloud.api;

import io.restassured.http.ContentType;
import org.entity.request.IngredientItem;
import org.entity.request.IngredientsRequest;
import org.entity.response.PriceResponse;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TotalPriceTests extends BaseApiTests {

    private static final String PATH = "api/GetPrice";

    @Test
    public void getTotalPriceTest() {

        given().baseUri(FUNCTION_URL)
                .queryParam("code", KEY)
                .when()
                .log().all()
                .get(PATH)
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .extract()
                .response();
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

        PriceResponse response = given().baseUri(FUNCTION_URL)
                .contentType(ContentType.JSON)
                .queryParam("code", KEY)
                .body(ingredientsRequest)
                .when()
                .log().all()
                .post(PATH)
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(PriceResponse.class);
    }
}