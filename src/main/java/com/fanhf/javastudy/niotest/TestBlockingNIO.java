package com.fanhf.javastudy.niotest;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author fanhf
 * @Description 选择器
 *
 * 一、使用NIO 完成网络通信的三个核心：
 *
 * 1、通道（Channel）：负责连接
 *     java.nio.channels.Channel 接口：
 *         |-- SelectableChannel
 *             |--SocketChannel
 *             |--ServerSocketChannel
 *             |--DatagramChannel
 *
 *             |--Pipe.SinkChannel
 *             |--Pipe.SourceChannel
 *
 * 2、缓冲区（Buffer）：负责数据的存区
 *
 * 3、选择器（Selector）：是SelectableChannel 的多路复用器，用于监控selectableChannel的IO状况
 *
 * @date 2020-12-31 15:01
 */
public class TestBlockingNIO {
    public static void main(String[] args){
        server();
        client();
    }
    //客户端
    public static void client(){
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
            FileChannel inchannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while(inchannel.read(buf)!=-1){
                buf.flip();
                socketChannel.write(buf);
                buf.clear();
            }
            //关闭发送通道，表明发送完毕
            socketChannel.shutdownOutput();

            //接收服务器的反馈
            int len = 0;
            while ((len = socketChannel.read(buf)) != -1) {
                buf.flip();
                System.out.println(new String(buf.array(), 0, len));
                buf.clear();
            }
            inchannel.close();
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //服务端
    public static void server() {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            FileChannel outchannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 9898));
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (socketChannel.read(buf) != -1) {
                buf.flip();
                outchannel.write(buf);
                buf.clear();
            }
            //发送反馈给客户端
            buf.put("服务端接收数据成功".getBytes());
            //改为读取模式
            buf.flip();
            socketChannel.write(buf);

            socketChannel.close();
            serverSocketChannel.close();
            outchannel.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
