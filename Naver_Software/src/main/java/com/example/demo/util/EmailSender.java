package com.example.demo.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	public static void sendEmail() {
		String host = "smtp.naver.com";
		String user = "";
		String password = "";
		
		//SMTP 서버 정보 설정
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() { 
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		
		try { 
			MimeMessage message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(""));
		  
			// 메일 제목 
			message.setSubject("Mail Test");
			
			// 메일 내용 
			message.setText("http://localhost:8080/naversw/main");
			  
			// send the message 
			Transport.send(message);
			System.out.println("Success Message Send"); 
			  
			} catch (Exception e) {
			  e.printStackTrace();
		}
	}

}
