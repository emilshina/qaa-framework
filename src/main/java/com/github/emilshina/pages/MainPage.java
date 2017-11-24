package com.github.emilshina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.github.emilshina.listeners.WebDriverListener.getDriver;

public class MainPage extends BasePage {
    private By inputSearch = By.cssSelector("#twotabsearchtextbox");
    private By linkSearchResults = By.cssSelector("li[id^='result_']");

    public MainPage searchFor(final String text) {
        type(inputSearch, text, ExpectedConditions::elementToBeClickable);
        return this;
    }

    public int getLinksAmount() {
        return getDriver().findElements(linkSearchResults).size();
    }
}
