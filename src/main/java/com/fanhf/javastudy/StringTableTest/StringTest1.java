package com.fanhf.javastudy.StringTableTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author fanhf
 * @Description -XX:StringTableSize=1009
 * @date 2020-12-24 18:19
 */
public class StringTest1 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我来打酱油了");
//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("words.txt"));
            long start = System.currentTimeMillis();
            String data;
            while ((data = br.readLine()) != null) {
                data.intern();
            }
            long end = System.currentTimeMillis();
            System.out.println("spend time:" + (end - start));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   
