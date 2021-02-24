package com.fanhf.javastudy.classcodetest;

import javax.print.attribute.standard.PrinterURI;
import java.util.Date;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-22 16:11
 */
public class MethodInvokeReturnTest {

    //方法调用指令：invokespecial
    public void invoke() {
        //情况1：类实例构造器方法：<init>()
        Date date = new Date();

        Thread thread = new Thread();
        ////情况2：父类的方法
        super.toString();
        //情况3：私有方法
        methodPrivate();
    }

    private void methodPrivate() {
    }

    public void invoke2() {
        methodStatic();
    }

    private static void methodStatic() {
    }

    //帆帆发调用指令：invokeinterface
    public void invoke3() {
        Thread thread = new Thread();

        thread.run();
        Comparable<Integer> com = null;
        com.compareTo(123);
    }

    //方法调用指令：invokeVirtual
    public void invoke4() {
        System.out.println("hello");
        Thread t1 = null;
        t1.run();
    }
}   
