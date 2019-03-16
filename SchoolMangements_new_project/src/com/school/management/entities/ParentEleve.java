package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ParentEleve
 *
 */
@Entity

public class ParentEleve implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idParent;
	private String nomParent;
	private String prenomParent;
	private String type;
	private String emailParent;
	//private String emailEleve;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEleve")
	private Eleve eleve;
	private static final long serialVersionUID = 1L;

	
	public ParentEleve(String nomParent, String prenomParent, String type, String emailParent) {
		super();
		this.nomParent = nomParent;
		this.prenomParent = prenomParent;
		this.type = type;
		this.emailParent = emailParent;
	}
	public ParentEleve() {
		super();
	}   
	public long getIdParent() {
		return this.idParent;
	}

	public void setIdParent(long idParent) {
		this.idParent = idParent;
	}   
	public String getNomParent() {
		return this.nomParent;
	}

	public void setNomParent(String nomParent) {
		this.nomParent = nomParent;
	}   
	public String getPrenomParent() {
		return this.prenomParent;
	}

	public void setPrenomParent(String prenomParent) {
		this.prenomParent = prenomParent;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public String getEmailParent() {
		return this.emailParent;
	}

	public void setEmailParent(String emailParent) {
		this.emailParent = emailParent;
	}
   
}
