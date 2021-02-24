package com.fanhf.javastudy.gcTest;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @author fanhf
 * @Description 强引用的测试
 * @date 2021-01-05 16:03
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Hello ,World");
        StringBuffer st1 = str;

        str = null;
        System.gc();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(st1);
    }

    public void softReference() {
        //声明强引用
        Object obj = new Object();
        SoftReference<Object> sf = new SoftReference<Object>(obj);
        obj = null;
    }

    public void phantomReference() {
        //声明虚引用
        Object obj = new Object();
        ReferenceQueue phantomQueue = new ReferenceQueue();
        PhantomReference<Object> sf = new PhantomReference<Object>(obj, phantomQueue);
        obj = null;
    }
}   
