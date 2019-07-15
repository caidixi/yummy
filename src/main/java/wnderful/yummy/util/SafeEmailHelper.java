package wnderful.yummy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component("safeEmailHelper")
public class SafeEmailHelper {
    private JavaMailSender jms;
    @Value("${spring.mail.self.username}")
    private String sender;

    @Autowired
    public SafeEmailHelper(JavaMailSender jms) {
        this.jms = jms;
    }

    @Async
    public  void sendMemberEmail(String email, String password){
        try{
            //建立邮件消息
            final MimeMessage mimeMessage = jms.createMimeMessage();
            final MimeMessageHelper mainMessage = new MimeMessageHelper(mimeMessage);
            //发送者
            mainMessage.setFrom(sender);
            //接收者
            mainMessage.setTo(email);
            //发送的标题
            mainMessage.setSubject("yummy系统，用户注册申请回复");
            //发送的内容
            mainMessage.setText("您的用户yummy账户密码为："+password+"\n"+"请凭此密码登陆");
            jms.send(mimeMessage);
        }catch (MessagingException ex){
            ex.printStackTrace();
        }
    }

    @Async
    public void sendRestaurantEmail(String email,String rid,String password){
        try{
            final MimeMessage mimeMessage = jms.createMimeMessage();
            final MimeMessageHelper mainMessage = new MimeMessageHelper(mimeMessage);
            mainMessage.setFrom(sender);
            mainMessage.setTo(email);
            mainMessage.setSubject("yummy系统，餐厅注册申请回复");
            mainMessage.setText("您的餐厅注册码为："+rid+"\n"+"您的餐厅yummy账户密码为："+password+"\n"+"请凭此餐厅注册码与密码登陆");
            jms.send(mimeMessage);
        }catch (MessagingException ex){
            ex.printStackTrace();
        }
    }
}
