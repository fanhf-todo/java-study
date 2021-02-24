package com.fanhf.javastudy.classloader;

/**
 * @author fanhf
 * @Description 测试自定义加载器
 * @date 2021-02-08 10:11
 */
public class MyClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader("d:/");
        Class clazz = null;
        try {
            clazz = loader.loadClass("MyClassLoader");
            System.out.println("加载此类的类加载器为：" + clazz.getClassLoader().getClass().getName());

            System.out.println("加载当前Demo类的类加载器的父类加载器为：" + clazz.getClassLoader().getParent().getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}   
