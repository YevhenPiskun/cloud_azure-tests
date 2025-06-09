package cloud.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    public void openMainPage() {

        given()
                .when()
                .log().all()
                .get("http://74.235.226.100:3000/")
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.HTML)
                .extract()
                .response();
    }

    @Test
    public void addNewIngredient() {

        String ingredient = String.format("Salmon%s", RandomStringUtils.randomAlphanumeric(6));

        given()
                .queryParam("title", ingredient)
                .queryParam("description", ingredient + " fish")
                .when()
                .log().all()
                .post("http://74.235.226.100:3000/ingredients/create")
                .then()
                .log().all()
                .statusCode(302)
                .extract()
                .response();

        Response response =
                given()
                        .when()
                        .log().all()
                        .get("http://74.235.226.100:3000/ingredients")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .response();

        Assert.assertTrue(response.getBody().prettyPrint().contains(ingredient));
    }
}