package com.github.emilshina.utils;

import com.github.emilshina.core.Page;

import static org.joor.Reflect.on;

/**
 * Runtime creation of pages.
 */

public class PageFactory {

    public static <T extends Page> T at(Class<T> pageClass) {
        return on(pageClass).create().get();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Page> T open(Class<T> pageClass) {
        return (T) at(pageClass).navigateTo();
    }
}
