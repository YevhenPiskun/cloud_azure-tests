package cloud.ui;

import com.codeborne.selenide.Configuration;
import org.page.*;
import org.testng.annotations.BeforeSuite;

public class BaseUiTests {

    protected MainPage mainPage = new MainPage();
    protected AddIngredientPage addIngredientPage = new AddIngredientPage();
    protected IngredientsListPage ingredientsListPage = new IngredientsListPage();
    protected AddPizzaPage addPizzaPage = new AddPizzaPage();
    protected PizzasListPage pizzasListPage = new PizzasListPage();
    protected SiteSettingsPage siteSettingsPage = new SiteSettingsPage();

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}