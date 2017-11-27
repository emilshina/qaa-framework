package com.github.emilshina.core;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Expected conditions.
 */

@Getter

public enum WaitCondition {
    visible(ExpectedConditions::visibilityOfElementLocated),
    present(ExpectedConditions::presenceOfElementLocated),
    enabled(ExpectedConditions::elementToBeClickable),
    allVisible(ExpectedConditions::visibilityOfAllElementsLocatedBy),
    allPresent(ExpectedConditions::presenceOfAllElementsLocatedBy);

    private final Function<By, ExpectedCondition<?>> type;
    //private final BiFunction<By, Integer, ExpectedCondition<?>> type;

    WaitCondition(Function<By, ExpectedCondition<?>> type) {
        this.type = type;
    }
}
