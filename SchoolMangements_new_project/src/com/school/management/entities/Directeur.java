package com.school.management.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: Directeur
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("DIR")
public class Directeur extends Membre implements Serializable {
	private String poste;
	private double salaire;
	private static final long serialVersionUID = 1L;

	public Directeur(String nomMembre, String prenomMembre, String sexeMembre, int ageMembre, String adresseMembre,
			String statutMembre, String loginMembre, String passewordMembre, Date dateEmbauche,
			 String poste, double salaire) {
		super(nomMembre, prenomMembre, sexeMembre, ageMembre, adresseMembre, statutMembre, loginMembre, passewordMembre,
				dateEmbauche);
		this.poste = poste;
		this.salaire = salaire;
	}

	public Directeur() {
		super();
	}   
  
	public String getPoste() {
		return this.poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}   
	public double getSalaire() {
		return this.salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
   
}
