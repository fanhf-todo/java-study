package com.fanhf.javastudy.classcodetest;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-23 13:24
 */
public class ExceptionTest {
    public void throwZero(int i) {
        if (i == 0) {
            throw new RuntimeException("参数值为0");
        }
    }

    public void throwOne(int i) throws RuntimeException {
        if (i == 1) {
            throw new RuntimeException("参数值为1");
        }
    }

    public void throwArithmetic() {
        int i = 10;
        int j = i / 10;
        System.out.println(j);
    }

    public void tryCatch() {
        try {
            File file = new File("d:/hello.txt");
            FileOutputStream fis = new FileOutputStream(file);

            String s = "hello!";

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }


    //思考：如下方法返回结果为多少？


    public static String func() {
        String str = "hello";
        try {
            return str;
        } finally {
            str = "fanhf";
        }
    }

    public static void main(String[] args) {
        System.out.println(func());
    }
}   
