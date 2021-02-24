package com.fanhf.javastudy.classcodetest;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-21 13:33
 */
public class SynchronizedTest {
    private int i = 0;

    public synchronized void add() {
        i++;
    }

    private Object obj = new Object();

    public void subtract() {
        synchronized (obj) {
            i--;
        }
    }
}   
