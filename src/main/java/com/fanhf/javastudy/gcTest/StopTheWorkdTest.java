package com.fanhf.javastudy.gcTest;

import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanhf
 * @Description Stop The Workd
 * @date 2021-01-05 14:47
 */
public class StopTheWorkdTest {
    public static class WorkThread extends Thread{
        List<byte[]> list = new ArrayList<>();
        @Override
        public void run(){
            try {
                while (true){
                    for (int i = 0; i < 1000; i++) {
                        byte[] buf = new byte[1024];
                        list.add(buf);
                    }
                    if (list.size() > 10000) {
                        list.clear();
                        System.gc();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class PrintThread extends Thread{
        public final long START_TIME = System.currentTimeMillis();
        @Override
        public void run(){
            try {
                while(true){
                    long t = System.currentTimeMillis() - START_TIME;
                    System.out.println(t / 1000 + "." + t % 1000);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WorkThread workThread = new WorkThread();
        PrintThread printThread = new PrintThread();
        workThread.start();
        printThread.start();
    }
}   
