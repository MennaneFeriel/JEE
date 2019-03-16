package com.school.management.sendMail;

import java.util.Properties;

public class MailUtil {

	// Propriétés SMTP pour l'envoi des emails
	private String host;
	private String user;
	private String password;

	private Properties javaMailProperties;

	public MailUtil()
	{
	}

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Properties getJavaMailProperties()
	{
		return javaMailProperties;
	}

	public void setJavaMailProperties(Properties javaMailProperties)
	{
		this.javaMailProperties = javaMailProperties;
	}

}
