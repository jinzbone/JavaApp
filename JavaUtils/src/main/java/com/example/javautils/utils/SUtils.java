package com.example.javautils.utils;

import java.util.regex.Pattern;

/**
 * @Description: 判断字符串的函数
 * @Author: zhangjing
 * @Date: 2021/3/2 9:44
*/

public class SUtils {


    /**
     * @Description: 判断一个字符串 是否是 整数
     * @Author: zhangjing
     * @Date: 2021/2/25 16:45
    */
    public static boolean isInteger(String s){
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(s).matches();
    }
    /**
     * @Description: 判断一个字符串 是否是 浮点数
     * @Author: zhangjing
     * @Date: 2021/2/25 16:45
     */
    public static boolean isFloat(String s){
        Pattern pattern = Pattern.compile("^[-\\+]?([1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*)");
        return pattern.matcher(s).matches();
    }
}
