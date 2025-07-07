package org.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.config.ConfigHolder;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    protected SelenideElement mainPageTitle = $(By.className("title"));
    protected SelenideElement generalMenu = $(By.xpath("//p[@class=\"menu-label\" and contains(text(),'General menu')]"));

    public void openMainPage() {
        open(ConfigHolder.getInstance().applicationIp());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        mainPageTitle.shouldHave(partialText("Catalog"));
    }

    public void generalMenuIsVisible() {
        generalMenu.shouldBe(Condition.visible);
    }
}