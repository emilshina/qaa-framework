package com.github.emilshina.testcases.amazon;

import com.github.emilshina.pages.MainPage;
import org.testng.annotations.Test;

import static com.github.emilshina.utils.PageFactory.at;
import static com.github.emilshina.utils.PageFactory.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Tests for Main Page.
 */

public class MainPageTests {

    @Test
    public void shouldSearchForKeywords() {
        open(MainPage.class)
                .searchFor("iphone")
                .getLinksAmount();

        assertThat(at(MainPage.class).getLinksAmount()).isGreaterThan(21);
    }
}
