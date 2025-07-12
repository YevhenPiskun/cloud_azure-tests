package cloud.ui;

import org.testng.annotations.Test;

public class MainPageTests extends BaseUiTests {

    @Test
    public void verifyAllMenuItems() {
        mainPage.openMainPage();
        mainPage.generalMenuIsVisible();
        mainPage.pizzaCatalogMenuItemIsVisible();
        mainPage.ourIngredientsMenuItemIsVisible();
        mainPage.administrationMenuMenuTitleIsVisible();
        mainPage.siteSettingsMenuItemIsVisible();
        mainPage.managePizzasMenuItemIsVisible();
        mainPage.managePizzasListMenuItemIsVisible();
        mainPage.managePizzasAddNewMenuItemIsVisible();
        mainPage.manageIngredientsMenuItemIsVisible();
        mainPage.manageIngredientsListMenuItemIsVisible();
        mainPage.manageIngredientsAddNewMenuItemIsVisible();
    }

    @Test
    public void addNewPizzaWithNewIngredient() {
        mainPage.openMainPage();
        mainPage.clickAddIngredients();
        addIngredientPage.enterTitle("Mozzarella");
        addIngredientPage.enterDescription("Mozzarella cheeze");
        addIngredientPage.clickSubmitButton();
        ingredientsListPage.lastIngredientHasTitle("Mozzarella");
        mainPage.clickAddNewPizza();
        addPizzaPage.enterTitle("Carbonara");
        addPizzaPage.uploadImage();
        addPizzaPage.clickSubmitButton();
        pizzasListPage.lastPizzaHasTitle("Carbonara (0 ing.)");
        pizzasListPage.clickLastAddIngredientButton();
        pizzasListPage.chooseLastIngredientInList();
        pizzasListPage.clickSubmitIngredientButton();
        pizzasListPage.lastPizzaHasTitle("Carbonara (1 ing.)");
    }
}