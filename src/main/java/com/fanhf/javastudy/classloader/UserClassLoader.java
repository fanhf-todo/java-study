package com.fanhf.javastudy.classloader;

import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;

import java.io.*;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-02-07 14:31
 */
public class UserClassLoader extends ClassLoader{
    private String rootDir;
    public UserClassLoader(String rootDir){
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //获取类地class文件字节数组
        byte[] classData = getClassdata(name);
        if (null == classData) {
            throw new ClassNotFoundException();
        }else {
            //直接生成class对象
            return defineClass(name,classData,0,classData.length);
        }
    }

    //编写获取class文件并转换为字节码流地逻辑
    private byte[] getClassdata(String name) {
        String path = classNameToPath(name);
        File file;
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String name) {
        return name;
    }

    public static void main(String[] args) {
        String rootDir = "";
        try {
            UserClassLoader loader1 = new UserClassLoader(rootDir);
            Class clazz1 = loader1.findClass("");

            UserClassLoader loader2 = new UserClassLoader(rootDir);
            Class clazz2 = loader2.findClass("");

            System.out.println(clazz1 == clazz2);
            System.out.println(clazz1.getClassLoader());
            System.out.println(clazz2.getClassLoader());

            Class clazz3 = ClassLoader.getSystemClassLoader().loadClass("");
            System.out.println(clazz3.getClassLoader());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
