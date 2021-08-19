package com.utils;

import java.util.regex.Pattern;

/**
 * @Title: 字符串类
 * @Author: ZhangJing
 * @Date:
 * @Description:
 * @Version 1.0
 */
public class JzStrUtils {

    /**
     * @Title: 字符串是个整数？
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static boolean isInteger(String s){
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(s).matches();
    }

    /**
     * @Title: 字符串是个浮点数？
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static boolean isFloat(String s){
        Pattern pattern = Pattern.compile("^[-\\+]?([1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*)");
        return pattern.matcher(s).matches();
    }
}
