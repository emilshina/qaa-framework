package com.github.emilshina.utils;

import static org.joor.Reflect.on;

/**
 * Creation objects with reflexion.
 */

public final class ReflectionUtils {
    private ReflectionUtils() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    public static <T> T getObject(final Class<T> entityClass, final Object... args) {
        return on(entityClass).create(args).get();
    }
}
