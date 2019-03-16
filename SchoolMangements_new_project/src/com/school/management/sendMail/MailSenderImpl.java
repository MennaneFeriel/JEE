package com.school.management.sendMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSenderImpl implements MailSender {

	private Properties props = new Properties();
	private MailUtil mailUtil;

	public MailSenderImpl(MailUtil mailUtil)
	{
		props = mailUtil.getJavaMailProperties();
		this.mailUtil = mailUtil;
	}

	// Permet d'envoyer un mail d'une adresse source vers une destination
	public void sendMail(final MailUtil mailUtil, String destination, String object, String texte) throws Exception
	{ 
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(mailUtil.getUser(), mailUtil.getPassword());
			}
		});

		try
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(destination));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destination));
			message.setSubject(object);
			message.setContent(texte, "text/html");

			Transport transport = session.getTransport("smtps");
			transport.connect(mailUtil.getHost(), mailUtil.getUser(), mailUtil.getPassword());
			transport.sendMessage(message, message.getAllRecipients());

		} catch (MessagingException ex)
		{
			throw new MailException(
					"Le mail n'a pas pu être envoyé, il se peut que le service soit temporairement indisponible, veuillez réessayer ultérieurement.");
		}
	}

}
