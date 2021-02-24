package com.fanhf.javastudy.classloader;

/**
 * @author fanhf
 * @Description 显式和隐式加载
 * @date 2021-02-07 14:22
 */
public class UserTest {
    User user = new User();//隐式加载
    public static void main(String[] args) {
        try {

            //显式加载
            //forName是静态方法，该方法在将Class文件加载到内存的同时，会执行类的初始化
            Class clazz = Class.forName("com.fanhf.javastudy.classloader.User");
            System.out.println(clazz);

            //loadClass是实例方法，该方法将Class文件加载到内存时，并不会执行类的初始化
            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.fanhf.javastudy.classloader.User");
            System.out.println(aClass);
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class User{
    static {
        System.out.println("我是User类的初始化");
    }
}
