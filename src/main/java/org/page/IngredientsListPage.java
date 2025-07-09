package org.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class IngredientsListPage {

    private final SelenideElement LAST_INGREDIENT_TITLE_IN_LIST = $(By.xpath("//table[@class=\"table\"]/tbody/tr[last()]/td"));

    public void lastIngredientHasTitle(String title) {
        LAST_INGREDIENT_TITLE_IN_LIST.shouldHave(Condition.text(title));
    }
}