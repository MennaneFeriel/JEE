package com.school.management.entities;

import java.io.Serializable;

//import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.ManyToOne;


/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	   
	@Id
	private long idMessage;
	private String contenuMessage;
	private String ojetMessage;
	private Date date;

	
	@ManyToOne  // plusieurs membres pr une mssg recu
	//@JoinColumn(name="idMembre")
	private Membre membre1;
	
	@ManyToOne  // plusieurs membres pr une mssg recu
	//@JoinColumn(name="idMembre")
	private Membre membre2;
	
	private static final long serialVersionUID = 1L;

	public Message(String contenuMessage, String ojetMessage, Date date) {
		super();
		this.contenuMessage = contenuMessage;
		this.ojetMessage = ojetMessage;
		this.date = date;
	}

	public Message() {
		super();
	}   
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Membre getMembre1() {
		return membre1;
	}

	public void setMembre1(Membre membre1) {
		this.membre1 = membre1;
	}

	public Membre getMembre2() {
		return membre2;
	}

	public void setMembre2(Membre membre2) {
		this.membre2 = membre2;
	}

	public String getOjetMessage() {
		return ojetMessage;
	}

	public void setOjetMessage(String ojetMessage) {
		this.ojetMessage = ojetMessage;
	}

	public long getIdMessage() {
		return this.idMessage;
	}

	public void setIdMessage(long idMessage) {
		this.idMessage = idMessage;
	}   
	public String getContenuMessage() {
		return this.contenuMessage;
	}

	public void setContenuMessage(String contenuMessage) {
		this.contenuMessage = contenuMessage;
	}   
//	public Date getDateReception() {
//		return this.dateReception;
//	}
//
//	public void setDateReception(Date dateReception) {
//		this.dateReception = dateReception;
//	}
   
}
