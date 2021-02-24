package com.fanhf.javastudy.classloader;
import org.junit.jupiter.api.Test;
import java.util.Random;

/**
 * @author fanhf
 * @Description  类的被动使用
 *
 * 设置参数:  -XX:+TraceClassLoading
 * @date 2021-01-29 13:38
 */
public class PassiveUse1 {

    /**
     * 1、当访问一个静态字段（static修饰）时，只有真正声明这个字段的类才会被初始化。
     *    当通过子类引用父类的静态的变量，不会导致子类初始化。
     */
    @Test
    public void test1(){
//      System.out.println(Son.num1);//Parent 会被初始化，但没有初始化不代表没有被加载
//      System.out.println(Son.num2);//子类不会被初始化，但没有初始化不代表没有被加载
      System.out.println(Son.num3);//父类子类都会被初始化
    }

    /**
     * 2、通过数组定义类引用，不会触发此类的初始化。
     * @date 2021-01-29 13:38
     */
    @Test
    public void test2(){
        Parent[] parents = new Parent[10];
        System.out.println(parents.getClass());
        System.out.println(parents.getClass().getSuperclass());

        parents[0] = new Parent();//会触发parent的初始化
        parents[1] = new Parent();//不会触发parent初始化（即不会打印“parent类初始化”），初始化只会执行一次

    }
}

class Parent {
    static {
        System.out.println("parent类初始化");
    }
    public static int num1 = 1;
}

class Son extends Parent{
    static {
        System.out.println("son类初始化");
    }
    public static  int num2 = 1;
    public static  int num3 = new Random().nextInt(10);
}
