package com.fanhf.javastudy.StringTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author fanhf
 * @Description 生成10万个长度不超过10的字符串。
 * @date 2021-01-08 18:16
 */
public class StringTableSize4GenerateString {
    public static void main(String[] args) {
        File file;
        try {
            FileWriter fw = new FileWriter("words.txt");
            for (int i = 0; i < 100000; i++) {
                int length = (int) (Math.random() * (10 - 1 + 1) + 1);
                fw.write(genString(length) + "\n");
            }
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String genString(int length) {
        String str = "";
        for (int i = 0; i < length; i++) {
            int num = (int) (Math.random() * (90 - 65 + 1) + 65 + (int) Math.random() * 2 * 32);
            str += (char) num;
        }
        return str;
    }
}

