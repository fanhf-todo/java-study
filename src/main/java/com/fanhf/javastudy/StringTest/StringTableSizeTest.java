package com.fanhf.javastudy.StringTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-08 18:11
 */
public class StringTableSizeTest {
    public static void main(String[] args) {
        System.out.println("啦啦啦啦啦.....");

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedReader br = null;


        try {
            br = new BufferedReader(new FileReader("words.txt"));
            long start = System.currentTimeMillis();
            String data;
            while ((data = br.readLine()) != null) {
                data.intern();
            }

            long end = System.currentTimeMillis();

            System.out.println("spend-time:" + (end - start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   
