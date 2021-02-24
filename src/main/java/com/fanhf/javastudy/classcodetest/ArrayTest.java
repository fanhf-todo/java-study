package com.fanhf.javastudy.classcodetest;

/**
 * @author fanhf
 * @Description 全类名：com.fanhf.javastudy.classcodetest
 * 全限定名：com/fanhf/javastudy/classcodetest
 * @date 2021-01-15 11:39
 */
public class ArrayTest {
    public static void main(String[] args) {
        Object[] arr = new Object[10];
        //[Ljava.lang.Object;@cc34f4d
        System.out.println(arr);

        String[] arr1 = new String[10];
        //[Ljava.lang.String;@17a7cec2
        System.out.println(arr1);

        long[][] arr2 = new long[10][];
        //[[J@65b3120a
        System.out.println(arr2);
    }
}   
