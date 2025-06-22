package cloud.ui;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageTests extends BaseUiTests {

    SelenideElement submitButton = $(By.xpath("//button[@type=\"submit\"]"));
    SelenideElement titleField = $(By.xpath("//input[@name=\"title\"]"));
    SelenideElement descriptionField = $(By.xpath("//textarea[@name=\"description\"]"));

    @Test
    public void verifyAllMenuItems() {
        mainPage.openMainPage();
        mainPage.generalMenuIsVisible();
        $(By.xpath("//a[@href=\"/\"]")).shouldHave(text("Pizza Catalog"));
        $(By.xpath("//a[@href=\"/our_ingredients\"]")).shouldHave(text("Our Ingredients"));
        $(By.xpath("//p[@class=\"menu-label\" and contains(text(),'Administration menu')]")).shouldBe(visible);
        $(By.xpath("//a[@href=\"/settings\"]")).shouldHave(text("Site Settings"));
        $(By.xpath("//a[@href=\"/pizzas\"]")).shouldHave(text("Manage Pizzas"));
        $(By.xpath("//a[@href=\"/pizzas\" and text()='List']")).shouldBe(visible);
        $(By.xpath("//a[@href=\"/pizzas/add\"]")).shouldHave(text("Add new"));
        $(By.xpath("//a[@href=\"/ingredients\"]")).shouldHave(text("Manage Ingredients"));
        $(By.xpath("//a[@href=\"/ingredients\" and text()='List']")).shouldBe(visible);
        $(By.xpath("//a[@href=\"/ingredients/add\"]")).shouldHave(text("Add new"));
    }

    @Test
    public void addNewPizzaWithNewIngredient() {
        mainPage.openMainPage();
        $(By.xpath("//a[@href=\"/ingredients/add\"]")).click();
        titleField.setValue("Mozzarella");
        descriptionField.setValue("Mozzarella cheeze");
        submitButton.click();
        $(By.xpath("//a[@href=\"/ingredients\" and text()='List']")).click();
        $$(By.xpath("//table[@class=\"table\"]/tbody/tr")).last().shouldHave(partialText("Mozzarella"));
        $(By.xpath("//a[@href=\"/pizzas/add\"]")).click();
        titleField.setValue("Carbonara");
        submitButton.click();
        $(By.xpath("//a[@href=\"/pizzas\" and text()='List']")).click();
        $$(By.xpath("//table[@class=\"table\"]/tbody/tr")).last().shouldHave(partialText("Carbonara (0 ing.)"));
        $(By.xpath("//table[@class=\"table\"]/tbody/tr[last()]//a[@data-title=\"Carbonara\" and contains(text(),'Add ingredient')]")).click();
        $(By.xpath("//select[@name=\"ingredient_id\"]")).getOptions().last().click();
        submitButton.click();
        $$(By.xpath("//table[@class=\"table\"]/tbody/tr")).last().shouldHave(partialText("Carbonara (1 ing.)"));
    }
}