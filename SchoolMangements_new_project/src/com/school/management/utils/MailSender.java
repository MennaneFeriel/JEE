package com.school.management.utils;

public interface MailSender {

	public void sendMail(final String source, String destination, String object, String texte) throws Exception;

}
