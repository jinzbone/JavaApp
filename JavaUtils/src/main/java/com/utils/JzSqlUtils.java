package com.utils;

/**
 * @Title: 常用SQL功能的语法参考
 * @Author: ZhangJing
 * @Date:
 * @Description:
 * @Version 1.0
 */
public class JzSqlUtils {
    public static String add_time_sql =
            "update danger_tb set @field = DATE_ADD(@field, interval 1 year) ";
}
