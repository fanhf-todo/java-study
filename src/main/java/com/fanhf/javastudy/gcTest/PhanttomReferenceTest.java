package com.fanhf.javastudy.gcTest;

import lombok.SneakyThrows;
import sun.security.krb5.internal.TGSRep;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-02-04 15:18
 */
public class PhanttomReferenceTest {
    public static PhanttomReferenceTest obj;//当前类对象的声明
    static ReferenceQueue<PhanttomReferenceTest> phantomQueue = null;//引用队列

    public static class  CheckRefQueue extends Thread{
       @Override
        public void run(){
            while (true){
                if (phantomQueue != null) {
                    PhantomReference<PhanttomReferenceTest> objt = null;
                    try {
                        objt = (PhantomReference<PhanttomReferenceTest>) phantomQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (objt != null) {
                        System.out.println("追踪垃圾回收过程：PhanttomReferenceTest实例被GC了");
                    }
                }
            }
        }
    }
    @Override
    protected void finalize() throws  Throwable{//finalize方法只能被调用一次
        super.finalize();
        System.out.println("调用当前类的finalize方法");
        obj = this;
    }

    public static void main(String[] args) {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);//设置为守护进程，只有非守护进程都不存在了，守护进程才会结束
        t.start();

        phantomQueue = new ReferenceQueue<>();
        obj = new PhanttomReferenceTest();
        //构造了PhanttomReferenceTest 对象的虚引用，并指定了引用队列
        PhantomReference<PhanttomReferenceTest> phantomReference = new PhantomReference<>(obj, phantomQueue);
        try {
            //不可获取虚引用中的对象
            System.out.println(phantomReference.get());
            //将强引用去除
            obj = null;
            //第一次gc，由于对象可复活，gc无法回收该对象
            System.gc();
            Thread.sleep(100);
            if (obj == null) {
                System.out.println("obj is null");
            } else {
                System.out.println("obj used");
            }
            System.out.println("第 2 次 GC");
            obj = null;
            //一旦将obj对象回收，就会将此虚引用存放到引用队列中。
            System.gc();
            Thread.sleep(1000);
            if (obj == null) {
                System.out.println("obj is null");
            } else {
                System.out.println("obj used");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}   
