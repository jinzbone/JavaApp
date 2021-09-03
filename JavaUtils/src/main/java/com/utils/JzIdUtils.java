package com.utils;

import java.util.UUID;

public class JzIdUtils {
    public static String createGUID(){
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        return uuid;
    }
}
