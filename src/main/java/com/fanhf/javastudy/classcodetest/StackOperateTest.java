package com.fanhf.javastudy.classcodetest;

import java.security.PublicKey;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-22 22:55
 */
public class StackOperateTest {
    public void print() {
        Object obj = new Object();
        obj.toString();
    }

    public void foo() {
        bar();
    }

    public long bar() {
        return 0;
    }

    public long nextIndex() {
        int index = 0;
        return index++;
    }
}   
