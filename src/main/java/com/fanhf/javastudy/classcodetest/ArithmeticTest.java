package com.fanhf.javastudy.classcodetest;

import org.junit.jupiter.api.Test;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-21 14:19
 */
public class ArithmeticTest {
    @Test
    public void method1() {
        int i = 10;
        double j = i / 0.0;
        //Infinity
        System.out.println(j);

        double d1 = 0.0;
        double d2 = d1 / 0.0;
        //NaN
        System.out.println(d2);
    }

    public int method5(int i, int j) {
        return ((i + j - 1) & ~(j - 1));

    }
}   
