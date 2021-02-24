package com.fanhf.javastudy.StringTableTest;

/**
 * @author fanhf
 * @Description 字符串的不可变性
 * @date 2020-12-24 18:07
 */
public class StringExer {

    String string = new String("good");
    char[] ch = {'t', 'e', 's', 't',};

    public static void main(String[] args) {
        StringExer se = new StringExer();
        se.change(se.string, se.ch);
        System.out.println(se.string);//good
        System.out.println(se.ch);//best
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
}   
