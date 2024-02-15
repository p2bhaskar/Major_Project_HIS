package com.pb.citizen_api.serviceImpl;

import com.pb.citizen_api.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public String sendSimpleEmail(EmailRequest request) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(request.getToEmail());
       // log.info("To Email: {}", request.getToEmail());
        mailMessage.setSubject(request.getSubject());
        mailMessage.setText(request.getMessageBody());
        javaMailSender.send(mailMessage);
        return "email successfully send to : " + request.getToEmail();
    }
}
