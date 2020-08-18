package com.sidj.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
  
    @Autowired
    public JavaMailSender emailSender;
 
    public void sendSimpleMessage(String to, String subject, String text, String from) 
    {
        
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setFrom(from);
        message.setSubject(subject); 
        message.setText(text);
        
        emailSender.send(message);
        
    }
    
    public void sendMessage(String to, String subject, String text, String from) 
    {
        
        SimpleMailMessage message = new SimpleMailMessage();
        
        
        message.setTo(to); 
        message.setFrom(from);
        message.setSubject(subject); 
        message.setText(text);
        
        emailSender.send(message);
        
    }
}
