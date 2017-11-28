package com.github.emilshina.core;

/**
 * Represents a function that accepts three arguments and produces a result.
 * @param <T> the type of the first argument to the function
 * @param <U> the type of the second argument to the function
 * @param <R> the type of the third argument to the function
 * @param <S> the type of the result of the function
 */

@FunctionalInterface
public interface TriFunction<T, U, R, S> {
    S apply(T t, U u, R r);
}
