package org.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class AddPizzaPage {

    private final SelenideElement SUBMIT_BUTTON = $(By.xpath("//button[@type=\"submit\"]"));
    private final SelenideElement TITLE_FIELD = $(By.xpath("//input[@name=\"title\"]"));
    private final SelenideElement CHOOSE_A_FILE_BUTTON = $(By.xpath("//input[@class='file-input']"));

    public void enterTitle(String title) {
        TITLE_FIELD.setValue(title);
    }

    public void clickSubmitButton() {
        SUBMIT_BUTTON.click();
    }

    public void uploadImage() {
        CHOOSE_A_FILE_BUTTON.uploadFile(new File(".\\src\\test\\resources\\pizza-picture.jpg"));
    }
}