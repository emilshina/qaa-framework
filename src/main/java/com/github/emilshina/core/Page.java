package com.github.emilshina.core;

import static com.github.emilshina.BaseConfig.BASE_CONFIG;

/**
 * Interface for all pages.
 */

public interface Page {

    Page navigateTo();

    default String url() {
        return BASE_CONFIG.url();
    }
}
