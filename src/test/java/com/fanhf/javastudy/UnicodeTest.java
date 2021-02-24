package com.fanhf.javastudy;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-17 16:59
 */
public class UnicodeTest {
    @Test
    public void test() {
        System.out.println(urlEncode("范慧芳"));
    }

    private String urlEncode(String param) {
        System.out.println("url编码前参数 param = " + param);
        try {
            String encode = URLEncoder.encode(param, "utf-8");
            System.out.println("url编码后参数 param = " + encode);
            return encode;
        } catch (UnsupportedEncodingException e) {
            System.err.println("TianyanchaService urlEncode编码失败：" + e.getMessage());
        }
        return null;
    }
    //缓存
    @Test
    public void test1(){
        String s = "1,3,5,6,9";
        if(s.indexOf("5")!=-1){
        int index = s.indexOf("5");
            s = s.substring(0, index) + s.substring(index +2);
            System.out.println(s);
        }

        // Intermediate Code Generator  中间代码生成器
        // Code Optimizer  代码优化器
        //Target Code Generator  目标代码生成器
        //Profiler
    }
}
