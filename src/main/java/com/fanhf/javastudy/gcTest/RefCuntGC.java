package com.fanhf.javastudy.gcTest;

/**
 * @author fanhf
 * @Description 证明java使用的不是引用计数算法
 *              -XX:+PrintGCDetails
 * @date 2021-01-25 13:37
 */
public class RefCuntGC {
    //这个成员属性的唯一的作用就是占用一点内存
    private byte[] bigSize = new byte[5 * 1024 * 1024];
    Object refer = null;

    public static void main(String[] args) {
        RefCuntGC obj1 = new RefCuntGC();
        RefCuntGC obj2 = new RefCuntGC();

        //循环引用
        //如果java使用的是引用计数算法，那么obj1和obj2就无法被gc回收
        //但实际上是发生了GC回收的过程
        obj1.refer = obj2;
        obj2.refer = obj1;

        obj1 = null;
        obj2 = null;

        //显式的执行垃圾回收行为
        //这里发生gc，obj1和obj2能否被回收？
        System.gc();
    }

}   
