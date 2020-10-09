package com.lcd.utils;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AES {

    static final String ALGORRITHM = "AES";
    //生成KEY值
    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        //用AES加密方式
        KeyGenerator secretGenerator = KeyGenerator.getInstance(ALGORRITHM);
        //生成随机值
        SecureRandom secureRandom = new SecureRandom();
        //初始化
        secretGenerator.init(secureRandom);
        //生成KEY值
        SecretKey secretKey = secretGenerator.generateKey();
        //返回KEY值
        return secretKey;
    }
    final static String charsetName = "UTF-8";
    static Charset charset = Charset.forName(charsetName);
    //加密操作
    public static byte[] encrypt(String content,SecretKey secretKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return aes(content.getBytes(charset),Cipher.ENCRYPT_MODE,secretKey);
    }
    //解密操作
    public static String decrypt(byte[] contentArray,SecretKey secretKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {

        byte[] result = aes(contentArray,Cipher.DECRYPT_MODE,secretKey);

        return new String(result,charsetName);
    }

    /**
     *
     * @param contenArray 传入的字节数
     * @param mode 加密or解密
     * @param secretKey Key值
     * @return
     */
    private static byte[] aes(byte[] contenArray,int mode,SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(ALGORRITHM);
        cipher.init(mode,secretKey);
        byte[] result = cipher.doFinal(contenArray);
        return result;
    }
}
