package com.school.management.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SupportCours
 *
 */
@Entity

public class SupportCours implements Serializable {  
	@Id
	private long idSup;
	private long nomFichier;
	private Date dateAjout;
	private Date dureeDeVie;
	@ManyToOne
	@JoinColumn(name="idMatiere")
	private Matiere matiere;
	private static final long serialVersionUID = 1L;

	public SupportCours() {
		super();
	}   
	public long getIdSup() {
		return this.idSup;
	}

	public void setIdSup(long idSup) {
		this.idSup = idSup;
	}   
	public long getNomFichier() {
		return this.nomFichier;
	}

	public void setNomFichier(long nomFichier) {
		this.nomFichier = nomFichier;
	}   
	public Date getDateAjout() {
		return this.dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}   
	public Date getDureeDeVie() {
		return this.dureeDeVie;
	}

	public void setDureeDeVie(Date dureeDeVie) {
		this.dureeDeVie = dureeDeVie;
	}
   
}
