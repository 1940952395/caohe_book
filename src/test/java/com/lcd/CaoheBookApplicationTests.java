package com.lcd;

import com.lcd.utils.AES;
import com.lcd.utils.IO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class CaoheBookApplicationTests {

    @Test
    void load(){

    }

    //AES加密测试
    @Test
    void testAES() throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        String content = "123131+!dwdasdn你叫";
         SecretKey secretKey = AES.generateKey();
         byte[] encryptResult = AES.encrypt(content,secretKey);
        System.out.println("加密后的结果为" +new String(encryptResult,"UTF-8"));
        String decryptResult = AES.decrypt(encryptResult,secretKey);
        System.out.println("解密后的结果为:"+decryptResult);
    }


    @Test
    void tessIO() throws IOException {
        IO.read("D:/桌面/小说/儒道至圣/第166章锁龙.text");
    }



}
