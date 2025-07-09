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

    private final SelenideElement MAIN_PAGE_TITLE = $(By.className("title"));
    private final SelenideElement GENERAL_MENU = $(By.xpath("//p[@class=\"menu-label\" and contains(text(),'General menu')]"));
    private final SelenideElement PIZZA_CATALOG_MENU_ITEM = $(By.xpath("//a[text()='Pizza Catalog' and @href='/']"));
    private final SelenideElement OUR_INGREDIENTS_MENU_ITEM = $(By.xpath("//a[@href=\"/our_ingredients\" and text()='Our Ingredients']"));
    private final SelenideElement ADMINISTRATION_MENU_MENU_TITLE = $(By.xpath("//p[@class=\"menu-label\" and contains(text(),'Administration menu')]"));
    private final SelenideElement SITE_SETTINGS_MENU_ITEM = $(By.xpath("//a[@href=\"/settings\" and text()='Site Settings']"));
    private final SelenideElement MANAGE_PIZZAS_MENU_ITEM = $(By.xpath("//a[@href=\"/pizzas\" and text()='Manage Pizzas']"));
    private final SelenideElement MANAGE_PIZZAS_LIST_MENU_ITEM = $(By.xpath("//a[@href=\"/pizzas\" and text()='List']"));
    private final SelenideElement MANAGE_PIZZAS_ADD_NEW_MENU_ITEM = $(By.xpath("//a[@href=\"/pizzas/add\" and text()='Add new']"));
    private final SelenideElement MANAGE_INGREDIENTS_MENU_ITEM = $(By.xpath("//a[@href=\"/ingredients\" and text()='Manage Ingredients']"));
    private final SelenideElement MANAGE_INGREDIENTS_LIST_MENU_ITEM = $(By.xpath("//a[@href=\"/ingredients\" and text()='List']"));
    private final SelenideElement MANAGE_INGREDIENTS_ADD_NEW_MENU_ITEM = $(By.xpath("//a[@href=\"/ingredients/add\" and text()='Add new']"));

    public void openMainPage() {
        open(ConfigHolder.getInstance().applicationIp());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        MAIN_PAGE_TITLE.shouldHave(partialText("Catalog"));
    }

    public void generalMenuIsVisible() {
        GENERAL_MENU.shouldBe(Condition.visible);
    }

    public void pizzaCatalogMenuItemIsVisible() {
        PIZZA_CATALOG_MENU_ITEM.shouldBe(Condition.visible, Condition.clickable);
    }

    public void ourIngredientsMenuItemIsVisible() {
        OUR_INGREDIENTS_MENU_ITEM.shouldBe(Condition.visible, Condition.clickable);
    }

    public void administrationMenuMenuTitleIsVisible() {
        ADMINISTRATION_MENU_MENU_TITLE.shouldBe(Condition.visible);
    }

    public void siteSettingsMenuItemIsVisible() {
        SITE_SETTINGS_MENU_ITEM.shouldBe(Condition.visible, Condition.clickable);
    }

    public void managePizzasMenuItemIsVisible() {
        MANAGE_PIZZAS_MENU_ITEM.shouldBe(Condition.visible, Condition.clickable);
    }

    public void managePizzasListMenuItemIsVisible() {
        MANAGE_PIZZAS_LIST_MENU_ITEM.shouldBe(Condition.visible, Condition.clickable);
    }

    public void managePizzasAddNewMenuItemIsVisible() {
        MANAGE_PIZZAS_ADD_NEW_MENU_ITEM.shouldBe(Condition.visible, Condition.clickable);
    }

    public void manageIngredientsMenuItemIsVisible() {
        MANAGE_INGREDIENTS_MENU_ITEM.shouldBe(Condition.visible, Condition.clickable);
    }

    public void manageIngredientsListMenuItemIsVisible() {
        MANAGE_INGREDIENTS_LIST_MENU_ITEM.shouldBe(Condition.visible, Condition.clickable);
    }

    public void manageIngredientsAddNewMenuItemIsVisible() {
        MANAGE_INGREDIENTS_ADD_NEW_MENU_ITEM.shouldBe(Condition.visible, Condition.clickable);
    }

    public void clickAddIngredients() {
        MANAGE_INGREDIENTS_ADD_NEW_MENU_ITEM.click();
    }

    public void clickListIngredients() {
        MANAGE_INGREDIENTS_LIST_MENU_ITEM.click();
    }

    public void clickAddNewPizza() {
        MANAGE_PIZZAS_ADD_NEW_MENU_ITEM.click();
    }
}