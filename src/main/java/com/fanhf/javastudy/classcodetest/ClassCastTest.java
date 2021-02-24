package com.fanhf.javastudy.classcodetest;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleConsumer;

/**
 * @author fanhf
 * @Description 宽化类型转换
 * @date 2021-01-21 16:01
 */
public class ClassCastTest {
    public void upCast1() {
        int i = 10;
        long l = i;
        float f = i;
        double d = i;

        float f1 = 1;
        double d1 = l;
        double d2 = f1;
    }

    @Test
    public void upCast2() {
        int i = 123123123;
        float f = i;
        //1.2312E8123
        System.out.println(f);

        long l = 123123123123L;
        l = 123123123123123123L;
        double d = l;
        //1.2312312312312312E17
        System.out.println(d);
    }

    public void upCast3(short s) {
        int i = s;
        long l = s;
        float f = s;
    }

    //窄化类型转换

    public void downCast1() {
        int i = 10;
        byte b = (byte) i;
        short s = (short) i;
        char c = (char) i;

        long l = 10L;
        int i1 = (int) l;
        byte b1 = (byte) l;
    }

    public void downCast2() {
        float f = 10;
        long l = (long) f;
        int i = (int) f;
        byte b = (byte) f;

        double d = 10;
        byte b1 = (byte) d;
    }

    //测试NaN，无穷大的情况
    @Test
    public void downCast5() {
        double d1 = Double.NaN;
        int i = (int) d1;
        //NaN
        System.out.println(d1);
        //0
        System.out.println(i);

        double d2 = Double.POSITIVE_INFINITY;
        long l = (long) d2;
        int j = (int) d2;
        //9223372036854775807
        System.out.println(l);

        //9223372036854775807
        System.out.println(Long.MAX_VALUE);
        //2147483647
        System.out.println(j);
        //9223372036854775807
        System.out.println(Long.MAX_VALUE);

        float f = (float) d2;
        //Infinity
        System.out.println(f);
    }
}   
