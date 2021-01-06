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
    public void test(){
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
                System.out.println(str +":"+strAnother);
            }
        }
    }
}   
