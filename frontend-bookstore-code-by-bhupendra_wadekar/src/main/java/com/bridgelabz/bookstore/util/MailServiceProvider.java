/**
 *
 */
package com.bridgelabz.bookstore.util;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailServiceProvider {
	public static void sendEmail(String toEmail, String subject, String body) {

		String fromEmail = System.getenv("waedekarbhupendra@gmail.com");
		String password = System.getenv("bhup@1995");

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.setProperty("mail.smtp.user", "waedekarbhupendra@gmail.com");
		prop.setProperty("mail.smtp.password", "bhup@1995");
		prop.put("mail.smtp.port", "587");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(prop, auth);
		send(session, fromEmail, toEmail, subject, body);
	}

	private static void send(Session session, String fromEmail, String toEmail, String subject, String body) {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail, "Bookstore"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);

		} catch (Exception e) {
			System.out.println("exception occured while sending mail");

		}
	}
}