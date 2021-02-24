package com.fanhf.javastudy.niotest;

import org.springframework.data.redis.connection.ReactiveListCommands;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-04 11:48
 */
public class TestNonBlockingNIO2 {
    public static void send() {
        try {
            DatagramChannel dc = DatagramChannel.open();
            dc.configureBlocking(false);
            ByteBuffer buf = ByteBuffer.allocate(1024);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                buf.put((LocalDateTime.now().toString() + ":\n" + str).getBytes());
                buf.flip();
                dc.send(buf, new InetSocketAddress("127.0.0.1", 9898));
                buf.clear();
            }
            dc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive() {
        try {
            DatagramChannel dc = DatagramChannel.open();
            dc.configureBlocking(false);
            dc.bind(new InetSocketAddress(9898));
            Selector selector = Selector.open();
            dc.register(selector, SelectionKey.OP_READ);
            while (selector.select() > 0) {
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey sk = it.next();

                    if (sk.isReadable()) {
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        dc.receive(buf);
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, buf.limit()));
                        buf.clear();
                    }
                }
                it.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}   
