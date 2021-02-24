package com.fanhf.javastudy.niotest;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-04 15:08
 */
public class TestPipe {
    public static void test() {
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

public static void zipFilePipe(){
    Long fileSize = 1024000L;
        try(WritableByteChannel out=Channels.newChannel(new FileOutputStream(""))){
            Pipe pipe = Pipe.open();
            //异步任务
            CompletableFuture.runAsync(() -> runTask(pipe));

            //获取通道
            ReadableByteChannel readableByteChannel = pipe.source();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) (fileSize * 10));
            while (readableByteChannel.read(byteBuffer) >= 0) {
                byteBuffer.flip();
                out.write(byteBuffer);
                byteBuffer.clear();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
}
    //异步任务
    public static void runTask(Pipe pipe){
        String prefix= "_";
        try (ZipOutputStream zos = new ZipOutputStream(Channels.newOutputStream(pipe.sink()));
             WritableByteChannel out = Channels.newChannel(zos)) {
             System.out.println("");
            for (int i = 0; i < 10 ; i++) {
                zos.putNextEntry(new ZipEntry(i + prefix));
                File file;
                FileChannel jpgChannel = new FileInputStream(new File("")).getChannel();
                jpgChannel.transferTo(0, 1024, out);
                jpgChannel.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}   



