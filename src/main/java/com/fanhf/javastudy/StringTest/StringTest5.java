package com.fanhf.javastudy.StringTest;


import org.junit.jupiter.api.Test;

public class StringTest5 {

    @Test
    public void test3() {
        String s1 = "a";
        StringBuilder st = new StringBuilder();
        st.append("11");
    }

    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        String str1 = "q";
        String str2 = "w";
        String str3 = "e";
        String str4 = "r";
        for (int i = 0; i < 100000; i++) {
            String str = str1 + i + str2 + i + str3 + i + str4 ;
        }
        long end = System.currentTimeMillis();
        System.out.println("spend-time:" + (end - start));
    }

    @Test
    public void tes11(){
        String str1 = "q";
        String str2 = "w";
        String str3 = "e";
        String str4 = "r";
        for (int i = 0; i < 100000; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = stringBuilder.append(str1).append(i).append(str2).append(i).append(str3).append(i).append(str4).toString();
        }
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        String str1 = "q";
        String str2 = "w";
        String str3 = "e";
        String str4 = "r";
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += str1 + i + str2 + i + str3 + i + str4 ;
        }
        long end = System.currentTimeMillis();
        System.out.println("spend-time:" + (end - start));
    }

    @Test
    public void tes21(){
        String str1 = "q";
        String str2 = "w";
        String str3 = "e";
        String str4 = "r";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
           stringBuilder.append(str1).append(i).append(str2).append(i).append(str3).append(i).append(str4).toString();
        }
    }
}
