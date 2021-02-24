package com.fanhf.javastudy.gcTest;

import java.lang.ref.WeakReference;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-02-04 15:02
 */
public class WeakRefenceTest {
    public static class  User{
        public User(int id,String name){
            this.id = id;
            this.name = name;
        }

        public int id;
        public String name;

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        //构造弱引用
        WeakReference<User> weakReference = new WeakReference<>(new User(1, "fanhf"));
        //从弱引用中重新获取对象
        System.out.println(weakReference.get());
        //垃圾回收
        System.gc();
        //不管当前内存是否充足，都会回收
        System.out.println("after GC");
        //重新获取弱引用中的对象
        System.out.println(weakReference.get());
    }
}
