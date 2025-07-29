package cloud.api;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class MainApiTests extends BaseApiTests {

    @Test
    public void openMainPage() {

        given()
                .baseUri(BASE_URL)
                .when()
                .log().all()
                .get("/")
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.HTML)
                .extract()
                .response();
    }

    @Test
    public void addNewIngredientAndAddItToNewPizza() {

        given()
                .baseUri(BASE_URL)
                .formParam("title", "Salmon")
                .formParam("description", "Salmon fish")
                .when()
                .log().all()
                .post("ingredients/create")
                .then()
                .log().all()
                .statusCode(302)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        String responseIngredients =
                given()
                        .baseUri(BASE_URL)
                        .when()
                        .log().all()
                        .get("/ingredients")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .response()
                        .asPrettyString();

        assertThat(responseIngredients).contains("Salmon");

        given()
                .baseUri(BASE_URL)
                .formParam("title", "Carbonara2")
                .when()
                .log().all()
                .post("/pizzas/create")
                .then()
                .log().all()
                .statusCode(302)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        given()
                .baseUri(BASE_URL)
                .formParam("pizza_id", "10")
                .formParam("ingredient_id", "12")
                .when()
                .log().all()
                .post("/pizzas/add_ingredient")
                .then()
                .log().all()
                .statusCode(302)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        String responsePizza =
                given()
                        .baseUri(BASE_URL)
                        .when()
                        .log().all()
                        .get("/pizzas")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .contentType(ContentType.HTML)
                        .extract()
                        .response()
                        .asPrettyString();

        Assert.assertTrue(responsePizza.contains("Carbonara (1 ing.)"));
    }

    @Test
    public void getPizzas() {

        String responseString = given()
                .baseUri(BASE_URL)
                .when()
                .log().all()
                .get("/")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response().asString();

        assertThat(responseString).contains("Awesome Pizza Site");
    }
}