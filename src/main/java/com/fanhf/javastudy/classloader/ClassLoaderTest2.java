package com.fanhf.javastudy.classloader;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-02-07 15:04
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            //rt.jar使用的是Bootstrap加载器，不是java类，所以获取不到
            System.out.println("classLoader:" + classLoader);

            ClassLoader classLoader1 = Class.forName("com.fanhf.javastudy.classloader.ClassLoaderTest2").getClassLoader();
            //自定义的类使用的是应用类加载器
            System.out.println("classLoader1:" + classLoader1);

            String[] stringArray = new String[10];
            //rt.jar包下的数组类型的加载器与数组元素类型的类加载器一致，String使用的是引导类加载器
            System.out.println("stringArray:" + stringArray.getClass().getClassLoader());

            //和数组元素类型的加载器一样
            ClassLoaderTest2[] arr1 = new ClassLoaderTest2[10];
            System.out.println("arr1:" + arr1.getClass().getClassLoader());

            int[] arr2 = new int[10];
            //基本数据类型不需要加载器
            System.out.println("arr2:" + arr2.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
