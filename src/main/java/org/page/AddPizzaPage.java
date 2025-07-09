package org.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddPizzaPage {

    private final SelenideElement SUBMIT_BUTTON = $(By.xpath("//button[@type=\"submit\"]"));
    private final SelenideElement TITLE_FIELD = $(By.xpath("//input[@name=\"title\"]"));

    public void enterTitle(String title) {
        TITLE_FIELD.setValue(title);
    }

    public void clickSubmitButton() {
        SUBMIT_BUTTON.click();
    }
}