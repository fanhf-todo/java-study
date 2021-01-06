package com.fanhf.javastudy.niotest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-04 15:08
 */
public class TestPipe {
    public static void test(){
        //1.获取管道
        try {
            Pipe pipe = Pipe.open();
            //2.将缓冲区中的数据写入管道
            ByteBuffer buf = ByteBuffer.allocate(1024);
            Pipe.SinkChannel sinkChannel = pipe.sink();
            buf.put("向单向管道发送数据".getBytes());
            buf.flip();
            sinkChannel.write(buf);

            //3.读取缓冲区中的数据
            Pipe.SourceChannel sourceChannel = pipe.source();
            buf.flip();
            int read = sourceChannel.read(buf);
            System.out.println(new String(buf.array(), 0, read));
            sourceChannel.close();
            sinkChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}   
