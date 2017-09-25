package com.thoughtworks.star.util;

import java.util.UUID;

public final class StringUtil {
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }
}
