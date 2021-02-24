package com.fanhf.javastudy.gcTest;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author fanhf
 * @Description -Xms60m -Xmx60m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -Xloggc:./logs/gc.log
 * @date 2021-01-12 15:26
 */
public class GCTLogest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            byte[] arr = new byte[1024 * 100];//100M
            list.add(arr);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}   
