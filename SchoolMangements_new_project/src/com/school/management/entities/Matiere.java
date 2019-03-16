package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: matiere
 *
 */
@Entity

public class Matiere implements Serializable {

	   
	@Id
	private long idMatiere;
	private int nombreHeure;
	private int coef;
	private String nomMatiere;
	private int descriptionMatiere;
	@OneToOne(cascade = CascadeType.ALL)
	private Seance seance;
	@OneToMany(mappedBy="matiere" ,fetch=FetchType.LAZY)
	private Collection<SupportCours> supportCours;
	@OneToMany(mappedBy="matiere" ,fetch=FetchType.LAZY)
	private Collection<Evaluation> evalutions;
	private static final long serialVersionUID = 1L;

	public Matiere() {
		super();
	}   
	public long getIdMatiere() {
		return this.idMatiere;
	}

	public void setIdMatiere(long idCour) {
		this.idMatiere = idCour;
	}   
	public int getNombreHeure() {
		return this.nombreHeure;
	}

	public void setNombreHeure(int nombreHeure) {
		this.nombreHeure = nombreHeure;
	}   
	public int getCoef() {
		return this.coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}   
	public String getNomMatiere() {
		return this.nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}   
	public int getDescriptionMatiere() {
		return this.descriptionMatiere;
	}

	public void setDescriptionMatiere(int descriptionMatiere) {
		this.descriptionMatiere = descriptionMatiere;
	}
   
}
