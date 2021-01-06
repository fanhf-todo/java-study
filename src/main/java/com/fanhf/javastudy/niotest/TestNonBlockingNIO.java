package com.fanhf.javastudy.niotest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author fanhf
 * @Description
 * @date 2021-01-04 11:19
 */
public class TestNonBlockingNIO {

    public  static void main(String[] args){

    }
    public static void client(){
        try {
            //1、获取通道
            SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
            //2、切换为非阻塞模式
            sChannel.configureBlocking(false);
            //3、分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //4、发送数据给服务端
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String  str= scanner.next();
                buf.put((LocalDateTime.now().toString() + "\n" + str).getBytes());
                buf.flip();
                sChannel.write(buf);
                buf.clear();
            }
            //5、关闭通道
            sChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void server(){
        try {
            //1、获取通道
            ServerSocketChannel ssChannel = ServerSocketChannel.open();
            //2、切换为非阻塞模式
            ssChannel.configureBlocking(false);
            //3、绑定连接
            ssChannel.bind(new InetSocketAddress(9898));
            //4、获取选择器
            Selector selector = Selector.open();
            //5、将通道注册到选择器上，并且指定“监听接收事件”
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
            //6、轮询式的获取选择器上已经“准备就绪”的事件
            while (selector.select() > 0){
                //7、获取当前选择器所有注册的“选择器（已就绪的监听事件）”
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()){
                    //8、获取准备“就绪”事件
                    SelectionKey sk = it.next();
                    //9、判断具体是什么时间准备就绪
                    if(sk.isAcceptable()){
                         //10、若“接受就绪”，获取客户端连接
                        SocketChannel socketChannel =ssChannel.accept();
                        //11、切换非阻塞模式
                        socketChannel.configureBlocking(false);
                        //12、将该通道注册到选择器上
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }else if(sk.isReadable()){
                        //13、获取当前选择器上“读就绪”状态的通道
                        SocketChannel socketChannel = (SocketChannel) sk.channel();
                        //14、读取数据
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        int length = 10;
                        while ((length = socketChannel.read(buf)) > 0) {
                            buf.flip();
                            System.out.println(new String(buf.array(), 0, length));
                            buf.clear();
                        }
                    }
                    //15、取消选择器SelectionKey
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}   
