package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: NiveauEtude
 *
 */
@Entity

public class NiveauEtude implements Serializable {

	@Id
	private long idNiveau;
	private String nomNiveau;
	private Date dateAjout; 
	@OneToMany(mappedBy="niveauEtude" ,fetch=FetchType.LAZY)
	private Collection<Classe> classes;
	@ManyToOne
	@JoinColumn(name="idSection")
	private Section section;
	private static final long serialVersionUID = 1L;

	public NiveauEtude() {
		super();
	}   
	public String getNomNiveau() {
		return this.nomNiveau;
	}

	public void setNomNiveau(String nomNiveau) {
		this.nomNiveau = nomNiveau;
	}   
	public Date getDateAjout() {
		return this.dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}   
	public long getIdNiveau() {
		return this.idNiveau;
	}

	public void setIdNiveau(long idNiveau) {
		this.idNiveau = idNiveau;
	}
   
}
