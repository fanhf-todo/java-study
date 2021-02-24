package com.fanhf.javastudy.classloader;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author fanhf
 * @Description 类的被动使用
 * 引用常量不会触发此类或者接口的初始化。因为常量在链接阶段就已经被显式赋值了。
 * @date 2021-01-29 14:16
 */
public class PassiveUse2 {
    /**
     * 3、引用常量不会触发此类或者接口的初始化。因为常量在链接过程的准备阶段就已经被显式赋值了。
     */
    @Test
    public void test(){
        System.out.println(Person.NUMBER);
        System.out.println(Person.NUMBER1);//这里由于要初始化Random，所以要先初始化Parent，
    }

    /**
     * 3、引用接口的变量不会触发此类接口的初始化。但如果变量的赋值是调用其他的new方法赋值的，此类就会被初始化
     */
    @Test
    public void test3(){
        System.out.println(YoungA.ID);//YoungA不会被初始化
//        System.out.println(YoungA.ID1);//YoungA会被初始化
    }
    /**
     * 4、调用ClassLoader类的loadClass()方法加载一个类，并不会对类的主动使用，不会导致类的初始化。
     */
    @Test
   public void test4(){
        try {
            System.out.println(ClassLoader.getSystemClassLoader().loadClass("com.fanhf.javastudy.classloader.Person"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Person{
    static {
        System.out.println("Person类的初始化");
    }
    public static final int NUMBER = 1;
    public static final int NUMBER1 = new Random().nextInt(10);
}

interface  YoungA{
    Thread t = new Thread() {
        {
            System.out.println("YoungA的初始化");
        }
    };
    int ID = 1;
    int ID1 = new Random().nextInt(10);
}


