/**
 * 
 */
package com.example.interceptor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author Aqeel
 *
 */

@Service
public class EmailService {

	Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}") 
    private String sender;
    
    @Value("${email.recipient}")
    private String emailRecipient;
    
    SimpleMailMessage mailMessage = new SimpleMailMessage();
   
    
    public String sendEmail() {
    	logger.info(">>>>>> sendEmail >> EmailService");
    	 // Setting up necessary details
        mailMessage.setFrom(sender);
        mailMessage.setTo(emailRecipient);
        mailMessage.setText("--text--");
        mailMessage.setSubject("--subject--");

        // Sending the mail
        javaMailSender.send(mailMessage);
        return "Mail Sent Successfully...";
    }
    
    
}
