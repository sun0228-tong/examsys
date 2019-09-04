package com.qfedu.examsys.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @ClassName MailUtil
 * @Description TODO
 * @Author GK
 * @Date 2019/9/3   8:44
 */
public class MailUtil implements Runnable {
    private String email;// 收件人邮箱
    private String code;// 验证码

    public MailUtil() {
    }

    public MailUtil(String email) {
        this.email = email;
    }

    public MailUtil(String email, String code) {
        this.email = email;
        this.code = code;
    }

    @Override
    public void run() {
        // 1.创建连接对象javax.mail.Session
        // 2.创建邮件对象 javax.mail.Message
        // 3.发送一封激活邮件
        String from = "1036673671@qq.com";// 发件人电子邮箱
        String host = "smtp.qq.com"; // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)

        Properties properties = System.getProperties();// 获取系统属性

        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证

        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1036673671@qq.com", "srperkdtqkqpbffe"); // 发件人邮箱账号、授权码
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // 2.3设置邮件主题
            message.setSubject("云考试报名通知!");
            // 2.4设置邮件内容
            String content = "";
                    content += "<html>";
                    content += "      <head></head>";
                    content += "      <body>";
                    content += "      <h1>建议您赶紧的报名考试，不然就给我SHUT UP!</h1>";
                    content += "      <h3>";
                    content += "          <a href='http://localhost:8080/videosys/page/before/reset_password2.jsp?email="+ email +"&code="+ code + "'>";
                    content += "            http://localhost:8080/videosys/page/before/reset_password2.jsp?email="+ email +"&code="+ code;
                    content += "          </href>";
                    content += "      </h3>";
                    content += "      </body>";
                    content += " </html>";

            //String content = "Hello world " + code ;
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
