package com.school.management.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Enseignant
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ENS")
public class Enseignant extends Membre implements Serializable {
	private String grade;
	private double salaire;
	@OneToMany(mappedBy="enseignant" ,fetch=FetchType.LAZY)
	private Collection<Seance> seances;
	private static final long serialVersionUID = 1L;

	
	public Enseignant(String nomMembre, String prenomMembre, String sexeMembre, int ageMembre, String adresseMembre,
			String statutMembre, String loginMembre, String passewordMembre, Date dateEmbauche,
			 String grade, double salaire) {
		super(nomMembre, prenomMembre, sexeMembre, ageMembre, adresseMembre, statutMembre, loginMembre, passewordMembre,
				dateEmbauche);
		this.grade = grade;
		this.salaire = salaire;
	}
	public Enseignant() {
		super();
	}  
	//@JsonIgnore
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}   
	public double getSalaire() {
		return this.salaire;
	}

//	public Collection<Seance> getSeances() {
//		return seances;
//	}
	public void setSeances(Collection<Seance> seances) {
		this.seances = seances;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}   
   
}
