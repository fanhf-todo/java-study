package com.fanhf.javastudy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-18 15:47
 */
public class ListForEacheTest {
    @Test
    public void test() {
        /**
         * 4 -6
         *
         *
         **/

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        List<String> list1 = new ArrayList<>();
        list1.add("11");
        list1.add("22");
        list1.add("33");
        list1.add("44");
        list1.add("55");
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
//            System.out.println("strSelf:"+str);
            for (int j = 0; j < list1.size(); j++) {
                String strAnother = list1.get(j);
//                System.out.println("strAnother:"+strAnother);
                System.out.println(str + ":" + strAnother);
            }
        }
    }

    @Test
    public void est1() throws Exception {
        int i = 10;
        try {
            for (int j = 0; j < 10; j++) {
                try {
                    System.out.println("111111111");
                    if (j == 5) {
                        try {
                            int s = 10 / 0;
                        } catch (Exception e) {
                            System.out.println("error");
                        }
                    }
                    System.out.println("j=" + j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   
