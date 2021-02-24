package com.fanhf.javastudy.niotest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * @author fanhf
 * @Description 通道
 * <p>
 * 一、通道（Channel）：用于源节点与目标节点的连接，在java NIO中负责缓冲区中的数据的传输，Channel本身不存储数据，需要配合缓冲区进行传输。
 * <p>
 * 二、通道的主要实现类
 * java.nio.channels.Channel接口：
 * |--FileChannel: 用于读取、写入、映射和操作文件的通道
 * |--SocketChannel: 通过 TCP 读写网络中的数据
 * |--ServerSocketChannel: 可以监听新进来的 TCP 连接，对每一个新进来的连接都会创建一个 SocketChannel.
 * |--DatagramChannel:通过 UDP 读写网络中的数据通道
 * <p>
 * 三、获取通道
 * 1、java针对支持通道的类提供了getChannel()方法
 * 本地IO：
 * FileInputStream/FileOutputStream
 * RandomAccessFile
 * <p>
 * 网络IO：
 * Socket
 * ServerSocket
 * DatagramSocket
 * <p>
 * 2、在JDK1.7 中的NIO.2 针对各个通道提供了静态方法 open()
 * 3、在JDK1.7 中的NIO.2 的Files工具类的newByteChannel()
 * <p>
 * 四、通道之间的数据传输
 * transferForm()
 * transferTo()
 * <p>
 * 五、分散（Scatter）与聚焦（Gather)
 * 分散读取（Scattering Reads)：将通道中的数据分到到多个缓冲区中
 * 聚集写入（Scattering Writes):将多个缓冲区中的数据聚集到通道中
 * <p>
 * 六、字符集：Charset
 * 编码：字符串 --> 字符数组
 * 解码：字符数组 --> 字符串
 * @date 2020-12-31 13:52
 */
public class TestChannel {
    public static void main(String[] args) {
//       test1();
//       test2();
//       test3();
//       test4();
        test5();
//       test6();
    }

    public static void test1() {
        long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        File file;
        try {
            fis = new FileInputStream("d:/1.avi");
            fos = new FileOutputStream("d:/2.avi");

            //1、获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //2、分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //3、将通道中的数据存入缓冲区中
            try {
                while (inChannel.read(buf) != -1) {
                    //切换读取数据的模式
                    buf.flip();
                    //4、将缓冲区中的数据写入通道中
                    outChannel.write(buf);
                    //清空缓冲区
                    buf.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        //耗费时间
        System.out.println("spend-time:" + (end - start));
    }

    //使用直接缓冲区完成文件的复制（内部映射文件）
    public static void test2() {
        long start = System.currentTimeMillis();
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("d:/1.avi"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("d:/2.avi"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            //内存映射文件
            MappedByteBuffer inMappedBuff = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuff = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接对缓冲区进行的读写操作
            byte[] dst = new byte[inMappedBuff.limit()];
            inMappedBuff.get(dst);
            outMappedBuff.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        //耗费时间
        System.out.println("spend-time:" + (end - start));
    }

    //通道直接的数据传输（直接缓冲区）
    public static void test3() {
        long start = System.currentTimeMillis();

        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("d:/1.avi"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("d:/1.avi"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            inChannel.transferTo(0, inChannel.size(), outChannel);
            outChannel.transferFrom(inChannel, 0, inChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        //耗费时间
        System.out.println("spend-time:" + (end - start));
    }

    //分段和聚集
    public static void test4() {
        RandomAccessFile raf1 = null;
        FileChannel channel1 = null;
        RandomAccessFile raf2 = null;
        FileChannel channel2 = null;

        try {
            raf1 = new RandomAccessFile("1.txt", "rw");

            //1、获取通道
            channel1 = raf1.getChannel();

            //2、分配指定大小的缓冲区
            ByteBuffer buf1 = ByteBuffer.allocate(100);
            ByteBuffer buf2 = ByteBuffer.allocate(1024);

            //3、分散读取
            ByteBuffer[] bufs = {buf1, buf2};
            channel1.read(bufs);

            for (ByteBuffer byteBuffer : bufs) {
                byteBuffer.flip();
            }

            System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
            System.out.println("-----------------------");
            System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

            //4、聚集写入
            raf2 = new RandomAccessFile("2.txt", "rw");
            channel2 = raf2.getChannel();

            channel2.write(buf2);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (channel2 != null) {
                try {
                    channel2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (channel1 != null) {
                try {
                    channel1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //输出支持的字符集
    public static void test5() {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> set = map.entrySet();

        for (Map.Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


    //字符集
    public static void test6() {
        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();

        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("范慧芳");
        charBuffer.flip();

        //编码
        ByteBuffer byteBuffer = null;
        try {
            byteBuffer = ce.encode(charBuffer);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        //如果put的是汉字，那么这里循环的次数最好是小于等于汉字个数的2倍，否则就会报BufferUnderFlowException
        for (int i = 0; i < 6; i++) {
            System.out.println(byteBuffer.get());
        }

        //解码
        byteBuffer.flip();
        CharBuffer charBuffer1 = null;
        try {
            charBuffer1 = cd.decode(byteBuffer);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        System.out.println(charBuffer1.toString());
    }
}
