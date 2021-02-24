package com.fanhf.javastudy.classcodetest;

import java.util.Date;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-20 14:11
 */
public class ConstantPushStackTest {
    //常量入栈指令
    public void pushConstantLdc() {
        int i = -1;
        int a = 5;
        int b = 6;
        int c = 127;
        int c1 = -120;
        int d = 128;
        int e = 32767;
        int f = 32768;
    }

    public void constLdc() {
        long a1 = 1;
        long a2 = 2;
        float b1 = 2;
        float b2 = 3;
        double c1 = 1;
        double c2 = 2;
        Date d = null;
    }

    public void store(int k, double d) {
        int m = k + 2;
        long l = 12;
        String str = "fanhf";
        float f = 10.0F;
        d = 10;
    }
}   
