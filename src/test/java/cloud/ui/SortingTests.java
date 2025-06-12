package cloud.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.CASE_INSENSITIVE_ORDER;

public class SortingTests extends BaseTests {

    ElementsCollection firstColumnTitles = $$(By.xpath("//section//div[@class=\"column\"][1]//h1[@class=\"title\"]"));
    ElementsCollection secondColumnTitles = $$(By.xpath("//section//div[@class=\"column\"][2]//h1[@class=\"title\"]"));

    @Test
    public void sortingFromAtoZVerification() {
        mainPage.openMainPage();
        $(By.xpath("//a[@href=\"/?page=0&sorting=1\"]")).click();
        List<String> firstActualSortingFromAtoZ = firstColumnTitles.stream().map(SelenideElement::getText).toList();
        List<String> secondActualSortingFromAtoZ = secondColumnTitles.stream().map(SelenideElement::getText).toList();
        List<String> actualSortingFromAtoZ = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            actualSortingFromAtoZ.add(firstActualSortingFromAtoZ.get(i));
            actualSortingFromAtoZ.add(secondActualSortingFromAtoZ.get(i));
        }
        List<String> expectedSortingFromAtoZ = new ArrayList<>(actualSortingFromAtoZ);
        expectedSortingFromAtoZ.sort(CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(actualSortingFromAtoZ, expectedSortingFromAtoZ);
    }

    @Test
    public void sortingFromZtoAVerification() {
        mainPage.openMainPage();
        $(By.xpath("//a[@href=\"/?page=0&sorting=2\"]")).click();
        List<String> firstActualSortingFromZtoA = firstColumnTitles.stream().map(SelenideElement::getText).toList();
        List<String> secondActualSortingFromZtoA = secondColumnTitles.stream().map(SelenideElement::getText).toList();
        List<String> actualSortingFromZtoA = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            actualSortingFromZtoA.add(firstActualSortingFromZtoA.get(i));
            actualSortingFromZtoA.add(secondActualSortingFromZtoA.get(i));
        }
        List<String> expectedSortingFromZtoA = new ArrayList<>(actualSortingFromZtoA);
        expectedSortingFromZtoA.sort(CASE_INSENSITIVE_ORDER.reversed());
        Assert.assertEquals(actualSortingFromZtoA, expectedSortingFromZtoA);
    }
}