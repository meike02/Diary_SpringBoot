package com.bimstart.demo.ordinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
@Component
public class Eamil_send {
    @Autowired
    JavaMailSender mailSender;
    public void send(String eamil_yanzhengma,String send_eamil) throws MessagingException {

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            /**
             * 使用MimeMessageHelper进行帮助邮件的发送
             * 参数 ：第一个imeMessage对象类型 第二个是是否开启附件传输 类型为boolean
             */
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

            helper.setSubject("验证码");
            helper.setText("您的平静日记邮箱验证码为："+eamil_yanzhengma+"不要给他人使用，非本人操作无需理会",true);
            helper.setTo(send_eamil);
            helper.setFrom("princebah@163.com");
//        helper.addAttachment("1.jpg",new File("C:/Users/Lenovo/Pictures/Saved Pictures/1.jpg"));
            mailSender.send(mimeMessage);
            System.out.println("成功");


    }
}
