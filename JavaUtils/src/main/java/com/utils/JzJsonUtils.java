package com.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

import java.util.Random;

/**
 * @Title: JSONArray操作类
 * @Author: ZhangJing
 * @Date:
 * @Description:
 * @Version 1.0
 */
public class JzJsonUtils {


    public static JSONArray shuffleJsonArray (JSONArray array) throws JSONException {
        // Implementing Fisher–Yates shuffle
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        for (int i = array.size() - 1; i >= 0; i--)
        {
            int j = rnd.nextInt(i + 1);
            // Simple swap
            Object object = array.get(j);
            array.set(j, array.get(i));
            array.set(i, object);
        }
        return array;
    }
}
