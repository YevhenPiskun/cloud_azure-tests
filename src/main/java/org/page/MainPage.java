package org.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    protected SelenideElement mainPageTitle = $(By.className("title"));
    protected SelenideElement generalMenu = $(By.xpath("//p[@class=\"menu-label\" and contains(text(),'General menu')]"));

    public void openMainPage() {
        open("http://74.235.232.155:3000/");
        mainPageTitle.shouldHave(partialText("Catalog"));
    }

    public void generalMenuIsVisible() {
        generalMenu.shouldBe(Condition.visible);
    }
}