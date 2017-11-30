package com.github.emilshina.pages;

import com.github.emilshina.core.Page;
import com.github.emilshina.core.WaitCondition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

import static com.github.emilshina.core.WaitCondition.allPresent;
import static com.github.emilshina.core.WaitCondition.enabled;
import static com.github.emilshina.utils.ElementTypeUtils.elementOf;
import static com.github.emilshina.utils.ElementTypeUtils.streamOf;
import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;

/**
 * Basic class for all pages.
 */
public abstract class BasePage implements Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.driver = getDriverMetaData()._1;
        this.wait = getDriverMetaData()._2;
    }

    @Step("Navigate to {url}")
    public Page navigateTo(final String url) {
        driver.get(url);
        return this;
    }

    protected void type(final By locator, final String text, final WaitCondition condition) {
        elementOf(waitFor(locator, condition)).sendKeys(text + Keys.ENTER);
    }

    protected void type(final By locator, final String text) {
        type(locator, text, enabled);
    }

    protected void click(final By locator, final WaitCondition condition) {
        elementOf(waitFor(locator, condition)).click();
    }

    protected List<String> getTextNodes(final By locator, final WaitCondition condition) {
        return streamOf(waitFor(locator, condition))
                .map(WebElement::getText)
                .toList();
    }

    protected List<String> getTextNodes(final By locator) {
        return getTextNodes(locator, allPresent);
    }

    @SuppressWarnings("unchecked")
    private <T, U, R, S> S waitFor(final T arg1, final U arg2, final R arg3, final WaitCondition condition) {
        return (S) wait.until((Function<WebDriver, ?>) condition.getType().apply(arg1, arg2, arg3));
    }

    @SuppressWarnings("unchecked")
    private <T, U, R> R waitFor(final T arg1, final U arg2, final WaitCondition condition) {
        return (R) waitFor(arg1, arg2, "", condition);
    }

    @SuppressWarnings("unchecked")
    private <T, U> U waitFor(final T arg1, final WaitCondition condition) {
        return (U) waitFor(arg1, "", condition);
    }
}
