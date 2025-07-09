package org.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddIngredientPage {

    private final SelenideElement TITLE_FIELD = $(By.xpath("//input[@name=\"title\"]"));
    private final SelenideElement DESCRIPTION_FIELD = $(By.xpath("//textarea[@name=\"description\"]"));
    private final SelenideElement SUBMIT_BUTTON = $(By.xpath("//button[@type=\"submit\"]"));

    public void enterTitle(String title) {
        TITLE_FIELD.setValue(title);
    }

    public void enterDescription(String description) {
        DESCRIPTION_FIELD.setValue(description);
    }

    public void clickSubmitButton() {
        SUBMIT_BUTTON.click();
    }
}