package com.fanhf.javastudy.builderreplcnew;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-21 10:50
 */
public class Builder<T> {
    private final Supplier<T> instantiator;
    private List<Consumer> modifiers = new ArrayList<>();

    public Builder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public static <T> Builder<T> of(Supplier<T> instant) {
        return new Builder<>(instant);
    }

    /**
     * 1、参数 Consumer
     **/
    @FunctionalInterface
    public interface Consumer1<T, P1> {
        /**
         * 接收参数方法
         *
         * @param t  对象
         * @param p1 参数二
         **/
        void accept(T t, P1 p1);
    }

    public <P1> Builder<T> with(Consumer1<T, P1> consumer, P1 p1) {
        Consumer<T> consumer1 = instantiator -> consumer.accept(instantiator, p1);
        modifiers.add(consumer1);
        return this;
    }

    /**
     * 2、参数 Consumer
     **/
    @FunctionalInterface
    public interface Consumer2<T, P1, P2> {
        /**
         * 接收参数方法
         *
         * @param t  对象
         * @param p1 参数一
         **/
        void accept(T t, P1 p1, P2 p2);
    }

    public <P1, P2> Builder<T> with(Consumer2<T, P1, P2> consumer, P1 p1, P2 p2) {
        Consumer<T> consumer2 = instantiator -> consumer.accept(instantiator, p1, p2);
        modifiers.add(consumer2);
        return this;
    }

    /**
     * 3、参数 Consumer
     **/
    @FunctionalInterface
    public interface Consumer3<T, P1, P2, P3> {
        /**
         * 接收参数方法
         *
         * @param t  对象
         * @param p1 参数一
         * @param p2 参数二
         * @param p3 参数三
         **/
        void accept(T t, P1 p1, P2 p2, P3 p3);
    }

    public <P1, P2, P3> Builder<T> with(Consumer3<T, P1, P2, P3> consumer, P1 p1, P2 p2, P3 p3) {
        Consumer<T> consumer3 = instantiator -> consumer.accept(instantiator, p1, p2, p3);
        modifiers.add(consumer3);
        return this;
    }

    /**
     * 4、参数 Consumer
     **/
    @FunctionalInterface
    public interface Consumer4<T, P1, P2, P3, P4> {
        /**
         * 接收参数方法
         *
         * @param t  对象
         * @param p1 参数一
         * @param p2 参数二
         * @param p3 参数三
         * @param p4 参数四
         **/
        void accept(T t, P1 p1, P2 p2, P3 p3, P4 p4);
    }

    public <P1, P2, P3, P4> Builder<T> with(Consumer4<T, P1, P2, P3, P4> consumer, P1 p1, P2 p2, P3 p3, P4 p4) {
        Consumer<T> consumer4 = instantiator -> consumer.accept(instantiator, p1, p2, p3, p4);
        modifiers.add(consumer4);
        return this;
    }

    /**
     * 5、参数 Consumer
     **/
    @FunctionalInterface
    public interface Consumer5<T, P1, P2, P3, P4, P5> {
        /**
         * 接收参数方法
         *
         * @param t  对象
         * @param p1 参数一
         * @param p2 参数二
         * @param p3 参数三
         * @param p4 参数四
         * @param p5 参数五
         **/
        void accept(T t, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);
    }

    public <P1, P2, P3, P4, P5> Builder<T> with(Consumer5<T, P1, P2, P3, P4, P5> consumer, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) {
        Consumer<T> consumer5 = instantiator -> consumer.accept(instantiator, p1, p2, p3, p4, p5);
        modifiers.add(consumer5);
        return this;
    }
    public T build() {
        T value = instantiator.get();
        modifiers.forEach(modifier -> modifier.accept(value));
        modifiers.clear();
        return value;
    }
}
