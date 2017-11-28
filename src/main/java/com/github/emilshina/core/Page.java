package com.github.emilshina.core;

import static com.github.emilshina.BaseConfig.BASE_CONFIG;

/**
 * Interface for all pages.
 */

public interface Page {

    Page navigateTo(String url);

    default Page navigateTo() {
        return navigateTo(url());
    }

    default String url() {
        return BASE_CONFIG.url();
    }
}
