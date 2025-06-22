package cloud.api;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MainApiTests extends BaseApiTests {

    @Test
    public void openMainPage() {

        given().baseUri(BASE_URL)
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
                .post("/ingredients/create")
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

        Assert.assertTrue(responseIngredients.contains("Salmon"));

        given()
                .baseUri(BASE_URL)
                .formParam("title", "Carbonara")
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

        String expectedString = "# Usage:\n" +
                "\n" +
                "GET /\n" +
                " * Returns this message\n" +
                "\n" +
                "POST /\n" +
                " * Returns report with provided inputs\n" +
                " * Sample request body:\n" +
                "    {\n" +
                "        \"Pizzas\": [\n" +
                "            {\n" +
                "                \"Name\": \"Xavier\",\n" +
                "                \"Ingredients\": [\"Onion\", \"Jam\", \"Cheese\"]\n" +
                "            },\n" +
                "            {\n" +
                "                \"Name\": \"Yvonne\",\n" +
                "                \"Ingredients\": [\"Ketchup\", \"Cheese\"]\n" +
                "            }            \n" +
                "        ]\n" +
                "    }\n" +
                "    ";

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

        Assert.assertEquals(responseString, expectedString);
    }
}