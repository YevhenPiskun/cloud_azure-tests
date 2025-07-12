package org.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PizzasListPage {

    private final SelenideElement LAST_PIZZA_IN_LIST = $(By.xpath("//table[@class=\"table\"]/tbody/tr[last()-1]"));
    private final SelenideElement LAST_ADD_INGREDIENT_BUTTON = $(By.xpath("//table[@class='table']/tbody/tr[last()-1]//a[contains(text(),'Add ingredient')]"));
    private final SelenideElement LAST_INGREDIENT_IN_LIST = $(By.xpath("//select[@name=\"ingredient_id\"]//option[last()]"));
    private final SelenideElement SUBMIT_BUTTON = $(By.xpath("//button[@type=\"submit\"]"));

    public void lastPizzaHasTitle(String title) {
        LAST_PIZZA_IN_LIST.shouldHave(Condition.text(title));
    }

    public void clickLastAddIngredientButton() {
        LAST_ADD_INGREDIENT_BUTTON.click();
    }

    public void chooseLastIngredientInList() {
        LAST_INGREDIENT_IN_LIST.click();
    }

    public void clickSubmitIngredientButton() {
        SUBMIT_BUTTON.click();
    }
}