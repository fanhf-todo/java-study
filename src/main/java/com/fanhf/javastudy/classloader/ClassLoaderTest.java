package com.fanhf.javastudy.classloader;

<<<<<<< HEAD
/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-19 16:13
 */
=======
>>>>>>> c588229b83e2dce89d2edfd8c1eb65fff1e71ff8
public class ClassLoaderTest {
    public static void main(String[] args){
        try {
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
<<<<<<< HEAD
            System.out.println(classLoader);

            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);

            ClassLoader classLoader2 =  ClassLoader.getSystemClassLoader();
            System.out.println(classLoader2);
=======
            System.out.println("classLoader:"+classLoader);

            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println("classLoader1:"+classLoader1);

            //系统类加载器
            ClassLoader systemClassLoader2 =  ClassLoader.getSystemClassLoader();
            //AppClassLoader
            System.out.println("systemClassLoader2:"+systemClassLoader2);

            //扩展类加载器
            ClassLoader extclassLoader = systemClassLoader2.getParent();
            //ExtClassLoader
            System.out.println("extclassLoader:"+extclassLoader);

            //获取不到引导类加载器
            ClassLoader bootStrapClassLoader = extclassLoader.getParent();
            //null
            System.out.println("bootStrapClassLoader:"+bootStrapClassLoader);

            //String类使用引导类加载器进行加载 ---> .Java的核心类库都是使用引导类加载器进行加载的
            //原因是: bootStrap是用C/C++语言编写的，而应用类加载器和扩展类加载器是java写的，所以无法获取到
            ClassLoader classLoader2 = String.class.getClassLoader();
            System.out.println("classLoader2:"+classLoader2);

            //自定义的是引用类加载器：AppClassLoader
            ClassLoader classLoader3 = ClassLoaderTest.class.getClassLoader();
            System.out.println("classLoader3:"+classLoader3);
>>>>>>> c588229b83e2dce89d2edfd8c1eb65fff1e71ff8

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD

=======
>>>>>>> c588229b83e2dce89d2edfd8c1eb65fff1e71ff8
    }
}   
