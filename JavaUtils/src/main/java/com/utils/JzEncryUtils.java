package com.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Title: 加密类
 * @Author: ZhangJing
 * @Date:
 * @Description:
 * @Version 1.0
 */
public class JzEncryUtils {

    /**
     * @Title: 对字符串加密，可选不同加密方法
     *          param1:加密类型（md5或者sha256）
     *          param2:需要加密的字符串
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static String encry(String type, String s){
        if (type==null) return null;
        if (type.equals("md5")) return DigestUtils.md5Hex(s);
        if (type.equals("sha256")) return DigestUtils.sha256Hex(s);
        return null;
    }

}
