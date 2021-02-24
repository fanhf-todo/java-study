package com.fanhf.javastudy.gcTest;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-28 14:56
 */
public class SystemGCTest {
    public static void main(String[] args){
        new SystemGCTest();
        //提醒jvm的垃圾回收器执行GC，但是不确定是否马上执行gc
        System.gc();
        //与Runtime.getRuntime().gc();的作用一样
        //下面的会强制调用使用引用的对象的finalize()方法
//        System.runFinalization();
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("SystemGCTest重写了finalize()");
    }

}   
