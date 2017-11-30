package com.github.emilshina.utils;

import com.github.emilshina.core.Page;

import static org.joor.Reflect.on;

/**
 * Runtime creation of pages.
 */

public final class PageFactory {

    private PageFactory() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    public static <T extends Page> T at(final Class<T> pageClass) {
        return on(pageClass).create().get();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Page> T open(final Class<T> pageClass) {
        return (T) at(pageClass).navigateTo();
    }
}
