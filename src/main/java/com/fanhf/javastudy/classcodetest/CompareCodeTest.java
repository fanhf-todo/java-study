package com.fanhf.javastudy.classcodetest;

import java.awt.geom.FlatteningPathIterator;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-22 23:06
 */
public class CompareCodeTest {
    public void compare1() {
        int a = 0;
        if (a != 0) {
            a = 10;
        } else {
            a = 20;
        }
    }

    public void compare2() {
        int a = 0;
        if (a == 0) {
            a = 10;
        } else {
            a = 20;
        }
    }

    public boolean compareNull(String str) {
        if (str == null) {
            return true;
        } else {
            return false;
        }
    }

    public void compare3() {
        float f1 = 9;
        float f2 = 10;
        System.out.println(f1 < f2);
    }

    public void compare4() {
        int i1 = 10;
        long l1 = 20;
        System.out.println(i1 > l1);
    }

    public int compare5(double d) {
        if (d > 50.0) {
            return 1;
        } else {
            return -1;
        }
    }
}   
