package com.github.emilshina.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.github.emilshina.BaseConfig.BASE_CONFIG;

/**
 * Page obiect class for Main page.
 */

public class MainPage extends BasePage {

    private final By inputSearch = By.cssSelector("#twotabsearchtextbox");
    private final By linkSearchResults = By.cssSelector("li[id^='result_']");

    @Step("Search for \"{text}\".")
    public MainPage searchFor(final String text) {
        type(inputSearch, text);
        return this;
    }

    public int getLinksAmount() {
        return getTextNodes(linkSearchResults).size();
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
