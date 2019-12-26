package com.tech.auth.common.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

public class ObjectUtil {

    public ObjectUtil() {
        super();
    }

    public static boolean isNullorEmpty(final Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof CharSequence) {
            return ((CharSequence) object).length() == 0;
        }
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }
        if (object instanceof Collection<?>) {
            return ((Collection<?>) object).isEmpty();
        }
        if (object instanceof Map<?, ?>) {
            return ((Map<?, ?>) object).isEmpty();
        }
        return false;
    }

    public static boolean isNotEmpty(final Object object) {
        return !isNullorEmpty(object);
    }

    public static <T> T defaultIfNull(final T object, final T defaultValue) {
        return object != null ? object : defaultValue;
    }

    public static <T> T getIfNull(final T object, final Supplier<T> defaultSupplier) {
        return object != null ? object : defaultSupplier == null ? null : defaultSupplier.get();
    }

    public static boolean allNotNull(final Object... values) {
        if (values == null) {
            return false;
        }

        for (final Object val : values) {
            if (val == null) {
                return false;
            }
        }

        return true;
    }

    @Deprecated
    public static boolean equals(final Object object1, final Object object2) {
        if (object1 == object2) {
            return true;
        }
        if (object1 == null || object2 == null) {
            return false;
        }
        return object1.equals(object2);
    }

    public static boolean notEqual(final Object object1, final Object object2) {
        return !equals(object1, object2);
    }
}
