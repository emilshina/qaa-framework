package com.github.emilshina.listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static java.util.Optional.ofNullable;

/**
 * Listener for WebDriver initialization before each test method and WebDriver quit after test invocation.
 * Based on Thread Local implementation for parallel runs.
 */

public class WebDriverListener implements IInvokedMethodListener {

    private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER_CONTAINER.get();
    }

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            DRIVER_CONTAINER.set(new ChromeDriver());
        }
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod()) {
            ofNullable(getDriver()).ifPresent(WebDriver::quit);
        }
    }
}
