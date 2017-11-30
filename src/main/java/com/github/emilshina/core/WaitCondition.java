package com.github.emilshina.core;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Expected conditions.
 */

@Getter
public enum WaitCondition {
    visible(ExpectedConditions::visibilityOfElementLocated),
    present(ExpectedConditions::presenceOfElementLocated),
    enabled((Function<By, ExpectedCondition<?>>) ExpectedConditions::elementToBeClickable),
    allVisible(ExpectedConditions::visibilityOfAllElementsLocatedBy),
    allPresent(ExpectedConditions::presenceOfAllElementsLocatedBy),
    valueToBe(ExpectedConditions::textToBe),
    attributeToBe((TriFunction<By, String, String, ExpectedCondition<?>>) ExpectedConditions::attributeToBe);

    private final TriFunction<?, ?, ?, ExpectedCondition<?>> type;

    WaitCondition(final TriFunction<?, ?, ?, ExpectedCondition<?>> type) {
        this.type = type;
    }

    <T, U, R> WaitCondition(final BiFunction<T, U, ExpectedCondition<?>> type) {
        this((T arg1, U arg2, R arg3) -> type.apply(arg1, arg2));
    }

    <T, U, R> WaitCondition(final Function<T, ExpectedCondition<?>> type) {
        this((T arg1, U arg2, R arg3) -> type.apply(arg1));
    }

    @SuppressWarnings("unchecked")
    public <T, V, R, S> TriFunction<T, V, R, S> getType() {
        return (TriFunction<T, V, R, S>) type;
    }
}
