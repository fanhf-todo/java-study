package com.fanhf.javastudy.classcodetest;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-23 00:05
 */
public class CompareJumpCodeTest {
    public void ifCompare1() {
        int i = 10;
        int j = 20;
        System.out.println(i < j);
    }

    public void ifCompare() {
        short s1 = 9;
        byte b1 = 10;
        System.out.println(s1 > b1);
    }

    public void ifCompare3() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1 == obj2);
        System.out.println(obj1 != obj2);
    }
}   
