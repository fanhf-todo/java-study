package com.fanhf.javastudy.gcTest;

/**
 * @author fanhf
 * @Description -Xmixed
 * int count = 10000000
 * VM Options采用模式              3次花费时间              排名
 * 默认：                 9647ms   8733ms    8733ms     2
 * -Xmixed:               6843ms   9388ms    10381ms    1
 * -Xint:                 84104ms  80985ms   83860ms    4
 * -Xcomp:                10330ms  10658ms   10805ms    3
 * <p>
 * int count = 1000000
 * VM Options采用模式              3次花费时间              排名
 * 默认：                 775ms    1786ms    1748ms      2
 * -Xmixed:               1608ms   1268ms    1471ms      3
 * -Xint:                 9538ms   8986ms    12063ms     4
 * -Xcomp:                926ms    921ms     1020ms      1
 * <p>
 * 结论：无论是1000000还是10000000，混合模式或者默认模式的排名都在第二或第三，而即时编译的排名不太稳定，最后一名始终都是编译器模式
 * @date 2021-01-07 10:03
 */
public class JITCompTest {
    public static void main(String[] args) {
        test();
//        long start = System.currentTimeMillis();
//
//        testPrimeNumer(1000000);
//
//        long end = System.currentTimeMillis();
//        System.out.println("spend-time:" + (end - start));
    }

    private static void testPrimeNumer(int count) {
        for (int i = 0; i < count; i++) {
            label:
            for (int j = 2; j <= 100; j++) {
                for (int k = 2; k < Math.sqrt(j); k++) {
                    if (j % k == 0) {
                        continue label;
                    }
                }
            }
        }
    }

    public static void test() {
        new Thread(() -> {
        }, "你当向鸟飞往你的山").start();
        new Thread(() -> {
        }, "在路上").start();
        new Thread(() -> {
        }, "局外人").start();
    }
}   
