package com.fanhf.javastudy.sendemail;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanhf
 * @Description 发送邮件测试
 * @date 2021-02-20 10:55
 */
public class SendMailTest {
    public static void main(String[] args) {
        List<String> mailTo = new ArrayList<>();
        mailTo.add("2424045058@qq.com");
//        mailTo.add("578650595@qq.com");
        List<String> ccMailAccounts = new ArrayList<>();
        ccMailAccounts.add("2424045058@qq.com");
        String title = "老范的牛年祝福";
        String content = "牛角勾福，牛尾扫凶，牛气十足，牛劲百倍，牛财旺盛，牛运亨通，牛星高照，牛福相随，牛年大吉！</br>" +
                "这些祝福只是九牛一毛，更多好事，正在赶来！！！" +
                "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbos.pgzs.com%2Frbpiczy%2FWallpaper%2F200901%2F13%2F37%2F4c2cf58cbdd728bf1f505ab76bbf1da8.jpg&refer=http%3A%2F%2Fbos.pgzs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616382551&t=dffe1305a8764fea4b2bafe1f0916ebc";
        try {
            SendEamilUtils.sendEmail(mailTo,ccMailAccounts,null,title,content,null);
            System.out.println("发送邮件成功............");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   
