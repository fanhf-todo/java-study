package com.fanhf.javastudy.gcTest;


import java.util.ArrayList;

/**
 * @author fanhf
 * @Description -XX:+PrintCommandLineFlags
 * <p>
 * -XX:+UseSerialGC :表明新生代使用Serial GC，同时老年代使用Serial Old GC
 * <p>
 * -XX:+UseParNewGC :表明新生代使用ParNew GC,老年代使用ParNew Old GC
 * @date 2021-01-06 17:09
 */
public class GCUseTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        while (true) {
            byte[] arr = new byte[100];
            list.add(arr);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}   
