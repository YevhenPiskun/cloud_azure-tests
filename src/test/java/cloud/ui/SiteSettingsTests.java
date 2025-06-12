package cloud.ui;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SiteSettingsTests extends BaseTests {

    @Test
    public void checkItemsPerPage() {
        mainPage.openMainPage();
        $(By.xpath("//a[@href=\"/settings\"]")).shouldHave(text("Site Settings")).click();
        String itemsPerPage = $(By.xpath("//input[@name=\"Catalog - items per page\"]")).getValue();
        int expectedItemsPerPage = Integer.parseInt(Objects.requireNonNull(itemsPerPage));
        $(By.xpath("//a[@href=\"/\"]")).shouldHave(text("Pizza Catalog")).click();
        int actualItemsPerPage = $$(By.xpath("//div[@class=\"block\"]")).size();
        Assert.assertEquals(actualItemsPerPage, expectedItemsPerPage);
    }

    @Test
    public void checkColumnsPerPage() {
        mainPage.openMainPage();
        $(By.xpath("//a[@href=\"/settings\"]")).shouldHave(text("Site Settings")).click();
        $(By.xpath("//input[@name=\"Catalog - number of columns\"]")).setValue("3");
        String columnsPerPage = $(By.xpath("//input[@name=\"Catalog - number of columns\"]")).getValue();
        int expectedColumnsPerPage = Integer.parseInt(Objects.requireNonNull(columnsPerPage));
        $(By.xpath("//a[@href=\"/\"]")).shouldHave(text("Pizza Catalog")).click();
        int actualColumnsPerPage = $$(By.xpath("//div[@class=\"column\"]")).size();
        Assert.assertEquals(actualColumnsPerPage, expectedColumnsPerPage);
    }
}