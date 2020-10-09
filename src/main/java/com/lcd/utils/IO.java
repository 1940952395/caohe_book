package com.lcd.utils;

import java.io.*;

public class IO {


    public static StringBuffer read(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String content;
        StringBuffer sb = new StringBuffer();
        while ((content=br.readLine())!=null){
            sb.append(content+"\n");

        }
        br.close();
       /* System.out.println(sb);*/
        return sb;
    }
}
