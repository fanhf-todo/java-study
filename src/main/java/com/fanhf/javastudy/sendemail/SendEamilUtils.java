package com.fanhf.javastudy.sendemail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author fanhf
 * @Description 发送邮件
 * @date 2021-02-20 10:08
 */
public class SendEamilUtils {
    private static String smtp_host="smtp.qq.com"; //邮件服务器域名
    private static String password_mailFrom="fanny2424045058";//邮件发件人邮箱密码
    private static String mailfrom="2424045058@qq.com";//邮箱发件人

    public static void sendEmail(List<String> mailTo,
                                 List<String> ccMailAccounts, List<String> bccMailAccounts,
                                 String title, String content,List<String> fileList) throws Exception {
        //1. 用于存放 SMTP 服务器地址等参数
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", smtp_host);//服务器地址
        properties.setProperty("mail.transport.protocol", "smtp");// 邮件协议
        properties.setProperty("mail.smtp.auth", "true");// 认证
//        properties.setProperty("mail.smtp.port", smtp_port);//端口

        // QQ邮箱设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        // 2. 创建session
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailfrom,"eeymxtetinsyeach");
            }
        });
        // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        // 3.创建邮件对象
        MimeMessage message = createSimpleMail(session, mailTo,ccMailAccounts, bccMailAccounts, title, content, fileList);
        // 4. 发送邮件,Transport每次发送成功程序帮忙关闭
        Transport transport = session.getTransport();
        transport.connect(mailfrom, password_mailFrom);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    /**
     * 创建只包含文本的邮件
     * @param session
     * @param mailTo 收件人邮箱
     * @param ccMailAccounts 抄送人邮箱
     * @param bccMailAccounts 密送人邮箱
     * @param title 标题
     * @param content 正文
     * @param  fileList 附件
     * @return
     * @throws Exception
     */
    private static MimeMessage createSimpleMail(Session session, List<String> mailTo,
                                                List<String> ccMailAccounts, List<String> bccMailAccounts,
                                                String title, String content, List<String> fileList) throws Exception{
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 邮件的标题
        message.setSubject(title, "UTF-8");
        // 邮件发送日期
        message.setSentDate(new Date());
        //  设置自定义发件人昵称
        String nick = "";
        try{
            nick = javax.mail.internet.MimeUtility.encodeText("fanhf");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        // 指明邮件的发件人
        message.setFrom(new InternetAddress(nick + " <" + mailfrom + ">"));
//        message.setFrom(new InternetAddress(mailfrom, mailfrom, "UTF-8"));
        // 指明邮件的收件人
        if ((mailTo != null) && (mailTo.size() > 0)) {
            InternetAddress[] sendTo = new InternetAddress[mailTo.size()];
            for (int i = 0; i < mailTo.size(); i++) {
                sendTo[i] = new InternetAddress(mailTo.get(i));
            }
            message.setRecipients(MimeMessage.RecipientType.TO, sendTo);
        }
        else {
            throw new Exception("收件人为空");
        }
        // 指明邮件的抄送人
        if ((ccMailAccounts != null) && (ccMailAccounts.size() > 0)) {
            InternetAddress[] ccMailAccount = new InternetAddress[ccMailAccounts.size()];
            for (int i = 0; i < ccMailAccounts.size(); i++) {
                ccMailAccount[i] = new InternetAddress(ccMailAccounts.get(i));
            }
            message.setRecipients(MimeMessage.RecipientType.CC, ccMailAccount);
        }
        //指明邮件密送人
        if ((bccMailAccounts != null) && (bccMailAccounts.size() > 0)) {
            InternetAddress[] bccMailAccount = new InternetAddress[bccMailAccounts.size()];
            for (int i = 0; i < bccMailAccounts.size(); i++) {
                bccMailAccount[i] = new InternetAddress(bccMailAccounts.get(i));
            }
            message.setRecipients(MimeMessage.RecipientType.BCC, bccMailAccount);
        }
        // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
        Multipart multipart = new MimeMultipart();
        // 添加邮件正文
        BodyPart contentBodyPart = new MimeBodyPart();
        // 邮件内容
        contentBodyPart.setContent(content, "text/html;charset=UTF-8");
        multipart.addBodyPart(contentBodyPart);

        // 添加附件
        if (fileList != null && fileList.size() > 0) {
            for(String filePath: fileList) {
                BodyPart attachmentBodyPart = new MimeBodyPart();
                // 根据附件路径获取文件,
                FileDataSource dataSource = new FileDataSource(filePath);
                attachmentBodyPart.setDataHandler(new DataHandler(dataSource));
                //MimeUtility.encodeWord可以避免文件名乱码
                attachmentBodyPart.setFileName(MimeUtility.encodeWord(dataSource.getFile().getName()));
                multipart.addBodyPart(attachmentBodyPart);
            }
        }
        // 邮件的文本内容
        message.setContent(multipart);
        message.saveChanges();
        return message;
    }
}   
