package com.github.emilshina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static com.github.emilshina.BaseConfig.BASE_CONFIG;
import static com.github.emilshina.listeners.WebDriverListener.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Basic class for all pages.
 */
public abstract class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, BASE_CONFIG.waitTimeout());
    }

    public void type(final By locator, final String text, Function<By, ExpectedCondition<WebElement>> condition) {
        waitFor(locator, condition).sendKeys(text + Keys.ENTER);
    }

    public void click(final By locator) {
        waitFor(locator, ExpectedConditions::elementToBeClickable).click();
    }

    private WebElement waitFor(final By locator, Function<By, ExpectedCondition<WebElement>> condition) {
        return wait.until(condition.apply(locator));
    }
}
