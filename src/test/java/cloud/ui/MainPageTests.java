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
        mainPage.pizzaCatalogMenuItemIsVisible();
        mainPage.ourIngredientsMenuItemIsVisible();
        mainPage.administrationMenuMenuTitleIsVisible();
        mainPage.siteSettingsMenuItemIsVisible();
        mainPage.managePizzasMenuItemIsVisible();
        mainPage.managePizzasListMenuItemIsVisible();
        mainPage.managePizzasAddNewMenuItemIsVisible();
        mainPage.manageIngredientsMenuItemIsVisible();
        mainPage.manageIngredientsListMenuItemIsVisible();
        mainPage.manageIngredientsAddNewMenuItemIsVisible();
    }

    @Test
    public void addNewPizzaWithNewIngredient() {
        mainPage.openMainPage();
        mainPage.clickAddIngredients();
        titleField.setValue("Mozzarella");
        descriptionField.setValue("Mozzarella cheeze");
        submitButton.click();
        $(By.xpath("//a[@href=\"/ingredients\" and text()='List']")).click();
        $$(By.xpath("//table[@class=\"table\"]/tbody/tr")).last().shouldHave(partialText("Mozzarella"));
        $(By.xpath("//a[@href=\"/pizzas/add\"]")).click();
        titleField.setValue("Carbonara");
        submitButton.click();
        $(By.xpath("//a[@href=\"/pizzas\" and text()='List']")).click();
        $$(By.xpath("//table[@class=\"table\"]/tbody/tr"))
                .get($$(By.xpath("//table[@class=\"table\"]/tbody/tr")).size() - 2)
                .shouldHave(partialText("Carbonara (0 ing.)"));
        $$(By.xpath("//table[@class=\"table\"]/tbody/tr"))
                .get($$(By.xpath("//table[@class=\"table\"]/tbody/tr")).size() - 2)
                .$(By.xpath("//a[@data-title=\"Carbonara\" and contains(text(),'Add ingredient')]")).click();
        $(By.xpath("//select[@name=\"ingredient_id\"]")).getOptions().last().click();
        submitButton.click();
        $$(By.xpath("//table[@class=\"table\"]/tbody/tr")).last().shouldHave(partialText("Carbonara (1 ing.)"));
    }
}