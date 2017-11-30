package com.github.emilshina.utils;

import one.util.streamex.StreamEx;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Class for types conversion of elements.
 */

public final class ElementTypeUtils {

    private ElementTypeUtils() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    public static <T> WebElement elementOf(final T element) {
        return (WebElement) element;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<WebElement> listOf(final T element) {
        return (List<WebElement>) element;
    }

    public static <T> StreamEx<WebElement> streamOf(final T element) {
        return StreamEx.of(listOf(element));
    }
}
