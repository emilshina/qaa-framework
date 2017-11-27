package com.github.emilshina.core;

/**
 * Interface for all pages.
 */

public interface Page {

    Page navigateTo();

    default String url() {
        return "http://localhost";
    }
}
