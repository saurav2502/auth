package com.tech.auth.common.util;

import java.util.Collection;

public class CollectionUtil {

    public static boolean isNullorEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

}
