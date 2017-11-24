package com.github.emilshina.testcases.amazon;

import com.github.emilshina.pages.MainPage;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.github.emilshina.BaseConfig.BASE_CONFIG;
import static com.github.emilshina.listeners.WebDriverListener.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Tests for Main Page.
 */

public class MainPageTests {

    @Test
    public void shouldSearchForKeywords() throws InterruptedException {
        getDriver().get(BASE_CONFIG.url());

        final int linksAmount = new MainPage().searchFor("iphone").getLinksAmount();
        assertThat(Objects.equals(linksAmount, 22));
    }
}
