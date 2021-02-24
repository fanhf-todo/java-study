package com.fanhf.javastudy.niotest;


import java.nio.ByteBuffer;

/**
 * @author fanhf
 * @Description 缓冲区
 * <p>
 * 一、缓冲区（Buffer）：在java NIO中负责数据的存取，缓冲区就是数组，用于存储不同数据类型的数据
 * 根据数据类型不同（Boolean 除外），提供了相应类型的缓冲区
 * <p>
 * ByteBuffer
 * CharBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 以上缓冲区的管理方式几乎一样，通过allocate()获取缓冲区
 * <p>
 * 二、缓冲区存取数据的两个核心方法：
 * put():存入数据到缓冲区
 * get():获取缓冲区的数据
 * <p>
 * 三、缓冲区四个核心属性
 * capacity ：容量，表示缓冲区中最大存储数据的容量，一旦声明不能改变。
 * limit ：界限，表示缓冲区中可以操作数据的大小。（limit 后的数据不能进行读写）
 * mark ：标记，表示记录当前position位置，可以通过reset()回复到mark的位置
 * position ：位置，表示缓冲区中正在操作数据的位置。
 * 0 <= mark <= position <= limit <= position
 * <p>
 * 四、直接缓冲区与非直接缓冲区
 * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中
 * 直接缓冲区：通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中，可以提高效率
 * 此方法返回的缓冲区进行分配和取消分配所需成本通常高于非直接缓冲区
 * 直接缓冲区主要分配给那些易受基础系统的本机I/O操作影响的大型、持久的缓冲区。
 * 最好仅在直接缓冲区，能在程序性能方面带来明显好处时分配它们。
 * 直接字符缓冲区还可以通过 FileChannel 的map()方法，将文件区域直接映射到内存中来创建，该方法返回MappedByteBuffer
 * @date 2020-12-31 09:52
 */
public class TestBuffer {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {
        String str = "abcde";
        //1、分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println("-------------allocate-------------");
        //0
        System.out.println(buf.position());
        //1024
        System.out.println(buf.limit());
        //1024
        System.out.println(buf.capacity());

        //2、利用put（）存放数据到缓冲区
        buf.put(str.getBytes());
        System.out.println("-----------put()------------");
        //5
        System.out.println(buf.position());
        //1024
        System.out.println(buf.limit());
        //1024
        System.out.println(buf.capacity());

        //3、切换到读取数据模式
        buf.flip();
        System.out.println("-----------flip()------------");
        //0
        System.out.println(buf.position());
        //5
        System.out.println(buf.limit());
        //1024
        System.out.println(buf.capacity());


        //4、利用get()读取缓冲区的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        //abcd
        System.out.println(new String(dst, 0, dst.length));
        System.out.println("-----------get()------------");
        //5
        System.out.println(buf.position());
        //5
        System.out.println(buf.limit());
        //1024
        System.out.println(buf.capacity());

        //5、rewind():可重复读
        buf.rewind();
        System.out.println("-----------rewind()------------");
        //0
        System.out.println(buf.position());
        //5
        System.out.println(buf.limit());
        //1024
        System.out.println(buf.capacity());

        //6、clear()清空缓存区，但是缓存区种的数据依然存在，但是处于“被遗忘”状态
        buf.clear();
        System.out.println("-----------clear()------------");
        //0
        System.out.println(buf.position());
        //1024
        System.out.println(buf.limit());
        //1024
        System.out.println(buf.capacity());
        //a
        System.out.println((char) buf.get());

    }

    public static void test2() {
        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();

        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 2);
        //ab
        System.out.println(new String(dst, 0, 2));
        //2
        System.out.println(buf.position());

        buf.mark();
        System.out.println("-----------mark()------------");

        //再读2个位置
        buf.get(dst, 2, 2);
        //ab
        System.out.println(new String(dst, 2, 2));
        //4
        System.out.println(buf.position());

        //reset():恢复到mark的位置
        buf.reset();
        System.out.println("-----------reset()------------");
        //2
        System.out.println(buf.position());

        System.out.println("-----------hasRemaining()------------");
        //判断缓冲区是否还有剩余数据
        if (buf.hasRemaining()) {
            //获取缓冲区中可以操作的数量
            //3
            System.out.println(buf.remaining());
        }
    }

    public static void test3() {
        //分配直接缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //false
        System.out.println(buf.isDirect());
    }
}   
