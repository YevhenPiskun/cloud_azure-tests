package cloud.ui;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageTests extends BaseUiTests {

    SelenideElement submitButton = $(By.xpath("//button[@type=\"submit\"]"));

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
        addIngredientPage.enterTitle("Mozzarella");
        addIngredientPage.enterDescription("Mozzarella cheeze");
        addIngredientPage.clickSubmitButton();
        ingredientsListPage.lastIngredientHasTitle("Mozzarella");
        mainPage.clickAddNewPizza();
        addPizzaPage.enterTitle("Carbonara");
        addPizzaPage.clickSubmitButton();
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