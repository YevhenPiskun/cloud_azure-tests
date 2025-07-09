package cloud.ui;

import com.codeborne.selenide.Configuration;
import org.page.AddIngredientPage;
import org.page.AddPizzaPage;
import org.page.IngredientsListPage;
import org.page.MainPage;
import org.testng.annotations.BeforeSuite;

public class BaseUiTests {

    protected MainPage mainPage = new MainPage();
    protected AddIngredientPage addIngredientPage = new AddIngredientPage();
    protected IngredientsListPage ingredientsListPage = new IngredientsListPage();
    protected AddPizzaPage addPizzaPage = new AddPizzaPage();

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}