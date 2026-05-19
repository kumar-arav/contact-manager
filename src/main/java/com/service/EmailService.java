package com.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.model.Email;

@Service
public class EmailService {

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(Email email)
	{
		
		try {
			
		MimeMessage mmessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mhelper = new MimeMessageHelper(mmessage, true);
		
		mhelper.setFrom(fromEmail);
		mhelper.setTo(email.getTo());
		mhelper.setSubject(email.getSubject());
		mhelper.setText(email.getMessage(), true);
	
		
		javaMailSender.send(mmessage);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
