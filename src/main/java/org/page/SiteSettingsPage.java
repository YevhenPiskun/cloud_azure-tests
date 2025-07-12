package org.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SiteSettingsPage {

    private final SelenideElement CATALOG_ITEM_PER_PAGE_INPUT_FIELD = $(By.xpath("//input[@name='Catalog - items per page']"));

    public String getValueFromCatalogItemPerPageInputField() {
        return CATALOG_ITEM_PER_PAGE_INPUT_FIELD.getValue();
    }
}