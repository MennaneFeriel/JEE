package com.school.management.sendMail;

public interface MailSender {

	public void sendMail(final MailUtil mailUtil, String destination, String object, String texte) throws Exception;
	
	

}
