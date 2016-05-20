package br.com;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * Fonte: http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
 * */

public class SendMailSSL {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("emailcriptografado.seguro@gmail.com", "j9s2lrp13");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("emailcriptografado.seguro@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("emailcriptografado.seguro@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
