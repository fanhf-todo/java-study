package com.fanhf.javastudy.utils;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-02-22 17:01
 */
@Slf4j
public class QRCodeUtil {

    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸
    private static final int QRCODE_SIZE = 360;
    // LOGO宽度
    private static final int WIDTH = 69;
    // LOGO高度
    private static final int HEIGHT = 69;


    /**
     * 生成二维码
     * @param content	源内容
     * @param imgPath	生成二维码保存的路径
     * @param needCompress	是否要压缩
     * @return		返回二维码图片
     * @throws Exception
     */
    private static BufferedImage createImage(String content, String imgPath, boolean needCompress) throws Exception {
//	Hashtable hints = new Hashtable();
//	hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//	hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
//	hints.put(EncodeHintType.MARGIN, 1);

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);//设置容错率默认为最高
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");// 字符编码为UTF-8
        hints.put(EncodeHintType.MARGIN, 0);//二维码空白区域,最小为0也有白边,只是很小,最小是6%左右

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
                hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入图片
        QRCodeUtil.insertImage1(image, needCompress);

        return image;
    }


    /**
     * 生成二维码
     * @param content	源内容
     * @param needCompress	是否要压缩
     * @return		返回二维码图片
     * @throws Exception
     */
    private static BufferedImage createImage1(String content, boolean needCompress) throws Exception {
//	Hashtable hints = new Hashtable();
//	hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//	hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
//	hints.put(EncodeHintType.MARGIN, 1);

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);//设置容错率默认为最高
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");// 字符编码为UTF-8
        hints.put(EncodeHintType.MARGIN, 0);//二维码空白区域,最小为0也有白边,只是很小,最小是6%左右

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
                hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        // 插入图片
        QRCodeUtil.insertImage1(image, needCompress);

        return image;
    }



    /**
     * 在生成的二维码中插入图片
     * @param source
     * @param needCompress
     * @throws Exception
     */
    private static void insertImage1(BufferedImage source,boolean needCompress) throws Exception {
        //ClassPathResource resource = new ClassPathResource("logo/logo.png");

        try (InputStream inputStream = new QRCodeUtil().getClass().getResourceAsStream("/logo/logo.png");){
            Image src = ImageIO.read(inputStream);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            if (needCompress) { // 压缩LOGO
                if (width > WIDTH) {
                    width = WIDTH;
                }
                if (height > HEIGHT) {
                    height = HEIGHT;
                }
                Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(image, 0, 0, null); // 绘制缩小后的图
                g.dispose();
                src = image;
            }
            // 插入LOGO
            Graphics2D graph = source.createGraphics();
            int x = (QRCODE_SIZE - width) / 2;
            int y = (QRCODE_SIZE - height) / 2;
            graph.drawImage(src, x, y, width, height, null);
            Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
            graph.setStroke(new BasicStroke(3f));
            graph.draw(shape);
            graph.dispose();
        }
        catch(Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 在生成的二维码中插入图片
     * @param source
     * @param imgPath
     * @param needCompress
     * @throws Exception
     */
    private static void insertImage(BufferedImage source, String imgPath, boolean needCompress) throws Exception {
        File file1 = new File(imgPath);
        if (!file1.exists()) {
            System.err.println("" + imgPath + "   该文件不存在！");
            return;
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 生成带logo二维码，并保存到磁盘
     * @param content
     * @param imgPath	logo图片
     * @param destPath
     * @param needCompress
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath, boolean needCompress,String file) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);


        mkdirs(destPath);
        ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
    }

    public static void mkdirs(String destPath) {
        File file = new File(destPath);
        // 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir。(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    public static void encode(String content, String imgPath, String destPath,String file) throws Exception {
        QRCodeUtil.encode(content, imgPath, destPath, false ,file);
    }

    public static void encode(String content, String destPath, boolean needCompress,String file) throws Exception {
        QRCodeUtil.encode(content, null, destPath, needCompress,file);
    }

    public static void encode(String content, String destPath,String file) throws Exception {
        QRCodeUtil.encode(content, null, destPath, false,file);
    }

    public static void encode(String content, String imgPath, OutputStream output, boolean needCompress)
            throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }

    public static void encode(String content, OutputStream output) throws Exception {
        QRCodeUtil.encode(content, null, output, false);
    }


    /**
     * 从二维码中，解析数据
     * @param file	二维码图片文件
     * @return	 返回从二维码中解析到的数据值
     * @throws Exception
     */
    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable hints = new Hashtable();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    public static String decode(String path) throws Exception {
        return QRCodeUtil.decode(new File(path));
    }


    public static byte[] getCodeByte(String content) throws Exception {
        BufferedImage image = QRCodeUtil.createImage1(content, true);

        // 创建输出流
        ByteArrayOutputStream byteArrayOutputStream = new  ByteArrayOutputStream();
        // 写入流
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        // 清流
        byteArrayOutputStream.flush();
        // 转为byte[]
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // 关流
        byteArrayOutputStream.close();
        return byteArray;
    }


    public static void writeToLocal(String destination, InputStream input)
            throws IOException {
        int index;
        byte[] bytes = new byte[1024];
        try(FileOutputStream downloadFile = new FileOutputStream(destination);) {
            while ((index = input.read(bytes)) != -1) {
                downloadFile.write(bytes, 0, index);
                downloadFile.flush();
            }
            input.close();
        }
    }
}
