package com.fanhf.javastudy.builderreplcnew;

import java.util.function.Consumer;

/**
 * @author fanhf
 * @Description 对象消费者
 * @date 2021-01-21 10:45
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Integer> consumer = (x) -> {
            int num = x * 10;
            System.out.println(num);
        };
        Consumer<Integer> consumer1 = (x) -> {
            int num = x * 20;
            System.out.println(num);
        };
        consumer.andThen(consumer1).accept(1);
    }
}   
