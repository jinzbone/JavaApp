package com;

import com.utils.JzEncryUtils;
import com.utils.JzIdUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static com.utils.JzEncryUtils.getDigest;

public class Main {
    public static void main(String[] args) throws Exception {
        String guid = JzIdUtils.createGUID();
        System.out.println(guid);
    }


}
