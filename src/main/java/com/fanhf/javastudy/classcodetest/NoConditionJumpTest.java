package com.fanhf.javastudy.classcodetest;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-23 12:56
 */
public class NoConditionJumpTest {
    //无条件跳转
    public void whileInt() {
        int i = 10;
        while (i < 100) {
            String s = "fanhf";
            i++;
        }
    }

    public void whileDouble() {
        double i = 0.0;
        while (i < 100.1) {
            String s = "fanhf";
            i++;
        }
    }

    //whileTest和forTest的操作的不同
    public void whileTest() {
        int i = 1;
        while (i <= 10) {
            i++;
        }
    }

    public void forTest() {
        for (int i = 0; i < 10; i++) {

        }
    }

    public void doWhileTest() {
        int i = 1;
        do {
            i++;
        } while (i <= 10);
    }
}   
