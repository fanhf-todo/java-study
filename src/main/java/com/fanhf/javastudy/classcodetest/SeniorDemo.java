package com.fanhf.javastudy.classcodetest;

/**
 * @author fanhf
 * @Description 需要分析对应的class文件
 * @date 2021-01-18 17:35
 */
public class SeniorDemo {
    private int num = 1;
    public final String INFO = "fanhf";
    boolean[] counts;

    public SeniorDemo() {
    }

    public SeniorDemo(int count) {
        this.counts = new boolean[count];
    }

    public String getInfo() {
        return INFO;
    }

    public void addNum(int n) {
        num += n;
        System.out.println(num);
    }
}   
