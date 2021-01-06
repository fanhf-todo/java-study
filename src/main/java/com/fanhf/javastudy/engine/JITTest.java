package com.fanhf.javastudy.engine;

import java.util.ArrayList;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-06 09:04
 */
public class JITTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("hello");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
