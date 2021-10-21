package com.bridgelabz.bookstore.util;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailProviderService {

	public  void sendMail(String emailContact, String emailSubject, String body) {

		String fromEmail =("waedekarbhupendra@gmail.com");
		String password =("bhup@1995");
		Properties property = new Properties();
		property.put("mail.smtp.auth", "true");
		property.put("mail.smtp.starttls.enable", "true");
		property.put("mail.smtp.host", "smtp.gmail.com");
		property.put("mail.smtp.port", "587");
		property.setProperty("mail.smtp.user", "waedekarbhupendra@gmail.com");
		property.setProperty("mail.smtp.password", "bhup@1995");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};


		Session session = Session.getInstance(property, auth);

	send(session, fromEmail, emailContact, emailSubject, body);


//	 sendHtml(session, fromEmail, emailContact, emailSubject, body);
	}// end of send mail

	private void send(Session session, String fromEmail, String emailContact, String emailSubject, String body) {
		// TODO Auto-generated method stub
		try {

			MimeMessage mimeMessage = new MimeMessage(session);

		mimeMessage.addHeader("Content-type", "text/HTML; charset=UTF-8");

			mimeMessage.addHeader("format", "flowed");

			mimeMessage.addHeader("Content-Transfer-Encoding", "8bit");

			mimeMessage.setFrom(new InternetAddress(fromEmail, "Bookstore"));

			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailContact));

			mimeMessage.setReplyTo(InternetAddress.parse(" u cannot waedekarbhupendra@gmail.com",false));

			mimeMessage.setSubject(emailSubject);

			mimeMessage.setText(body);


			Transport.send(mimeMessage);
			System.out.println("Message sent succesfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occured while sending mail");

		}
		return ;
	}

	//for html content

//
//	private void sendHtml(Session session, String fromEmail, String emailContact, String emailSubject, String body) {
//		// TODO Auto-generated method stub
//		try {
//			MimeMessage message = new MimeMessage(session);
//			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
//
//			message.addHeader("format", "flowed");
//
//			message.addHeader("Content-Transfer-Encoding", "8bit");
//
//			message.setFrom(new InternetAddress(fromEmail, "Bookstore"));
//
//			message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailContact));
//
//			message.setReplyTo(InternetAddress.parse(" u cannot @gmial.com",false));
//
//			message.setSubject(emailSubject);
//
//
//			MimeMessageHelper helper = new MimeMessageHelper(message);
//			helper.setTo(emailContact);
//			helper.setSubject(emailSubject);
//			helper.setText(body, true);
//
//			Transport.send(message);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("exception occured while sending mail");
//
//		}
//	}





}