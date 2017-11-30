package com.github.emilshina.testcases.amazon;

import com.github.emilshina.pages.MainPage;
import io.qameta.allure.*;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static com.github.emilshina.utils.PageFactory.at;
import static com.github.emilshina.utils.PageFactory.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Tests for Main Page.
 */

public class MainPageTests {

    @Test(description = "Should search for keywords.")
    @Feature("Search")
    @Story("Searh functionality")
    @Issue("5")
    @TmsLink("5")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldSearchForKeywords() {
        open(MainPage.class)
                .searchFor("iphone")
                .getLinksAmount();

        assertThat(at(MainPage.class).getLinksAmount()).isGreaterThan(21);
    }

    @Test
    public void skipTest() {
        throw new SkipException("Not implemented.");
    }

    @Test
    public void brokenTest() {
        throw new IllegalStateException("Environment is not available.");
    }
}
