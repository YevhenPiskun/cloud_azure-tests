package cloud.ui;

import com.codeborne.selenide.Configuration;
import org.page.MainPage;
import org.testng.annotations.BeforeSuite;

public class BaseUiTests {
    protected MainPage mainPage = new MainPage();

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}