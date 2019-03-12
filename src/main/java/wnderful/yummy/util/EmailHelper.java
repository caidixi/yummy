package wnderful.yummy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("emailHelper")
public class EmailHelper {
    private JavaMailSender jms;

    @Autowired
    public EmailHelper(JavaMailSender jms) {
        this.jms = jms;
    }

    public  void sendMemberEmail(String email, String password){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("caidixi@163.com");
        //接收者
        mainMessage.setTo(email);
        //发送的标题
        mainMessage.setSubject("yummy系统，用户注册申请回复");
        //发送的内容
        mainMessage.setText("您的用户yummy账户密码为："+password+"\n"+"请凭此密码登陆");
        jms.send(mainMessage);
    }

    public void sendRestaurantEmail(String email,String rid,String password){
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        mainMessage.setFrom("caidixi@163.com");
        mainMessage.setTo(email);
        mainMessage.setSubject("yummy系统，餐厅注册申请回复");
        mainMessage.setText("您的餐厅注册码为："+rid+"\n"+"您的餐厅yummy账户密码为："+password+"\n"+"请凭此餐厅注册码与密码登陆");
        jms.send(mainMessage);
    }
}
