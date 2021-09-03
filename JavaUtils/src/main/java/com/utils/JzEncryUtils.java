package com.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    /**
     * @Title: 对文件进行md5加密
     * @Author: ZhangJing
     * @Date:
     * @Description:
     * @Version 1.0
     */
    public static String getDigest(String  dir) throws NoSuchAlgorithmException, IOException {
        @SuppressWarnings("resource")
        FileInputStream is = new FileInputStream(dir);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        byte[] bytes = new byte[2048];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            md.update(bytes, 0, numBytes);
        }
        byte[] digest = md.digest();
        System.out.println(digest);
        String result = new String(Hex.encodeHex(digest));
        result = Base64.encodeBase64String(result.getBytes());
        return result;
    }

    public static void givenPassword_whenHashing_thenVerifying()
            throws NoSuchAlgorithmException {
        String password = "ILoveJava";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
//        digest是md5值
        byte[] digest = md.digest();

//        result是将md5转为base64
        String result = new String(Hex.encodeHex(digest));
        result = Base64.encodeBase64String(result.getBytes());

    }

}
