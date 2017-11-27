package com.github.emilshina.pages;

import org.openqa.selenium.By;

import static com.github.emilshina.BaseConfig.BASE_CONFIG;

public class MainPage extends BasePage {

    private By inputSearch = By.cssSelector("#twotabsearchtextbox");
    private By linkSearchResults = By.cssSelector("li[id^='result_']");

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
