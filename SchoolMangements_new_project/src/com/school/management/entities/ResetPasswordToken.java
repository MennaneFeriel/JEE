package com.school.management.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "ResetPasswordToken.find", query = "select x from ResetPasswordToken x where x.token = :token"),
		@NamedQuery(name = "ResetPasswordToken.findAll", query = "select x from ResetPasswordToken x") })
public class ResetPasswordToken implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_user;

	@Column(nullable = false)
	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateCreation;

	public ResetPasswordToken()
	{
		super();
	}

	public Long getId_user()
	{
		return this.id_user;
	}

	public void setId_user(Long id_user)
	{
		this.id_user = id_user;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public Date getDateCreation()
	{
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation)
	{
		this.dateCreation = dateCreation;
	}

}
