package com.fanhf.javastudy.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-02-08 09:57
 */
public class LoopRun {
    public static void main(String[] args) {
        while (true) {
            try {
                //创建自定义类加载器的实例
                MyClassLoader loader = new MyClassLoader("D:\\tools\\IDEA\\workspaces\\java-study\\target\\classes\\com\\fanhf\\javastudy\\classcodetest\\");
                //加载指定的类
                Class clazz = loader.findClass("Demo");
                //创建运行时类的实例
                Object demo = clazz.newInstance();
                //获取运行时类的指定方法
                Method m = clazz.getMethod("hot");
                //调用指定的方法
                m.invoke(demo);
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Demo1{
    public void hot(){
        System.out.println("OldDemo1");
    }
}
