package com.fanhf.javastudy.classcodetest;

import javax.naming.event.ObjectChangeListener;
import java.io.File;

/**
 * @author fanhf
 * @Description 对象、数组的创建于访问指令
 * @date 2021-01-22 15:06
 */
public class NewTest {
    //1、创建指令
    public void newInstance() {
        Object obj = new Object();
        File file = new File("fanhf");
    }

    public void newArray() {
        int[] intArray = new int[10];
        System.out.println(intArray[1]);
        Object[] objArray = new Object[10];
        int[][] mintArray = new int[10][10];
        String[][] strings = new String[10][];
    }
}   
