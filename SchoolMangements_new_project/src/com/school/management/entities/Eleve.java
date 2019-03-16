package com.school.management.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Eleve
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ELE")
public class Eleve extends Membre implements Serializable {

	// private long idElv;
	@OneToOne(cascade = CascadeType.ALL)
	private ParentEleve parentEleve;
	@OneToMany(mappedBy = "eleve", fetch = FetchType.LAZY)
	private Collection<ListePresence> ListePresences;
	@OneToMany(mappedBy = "eleve", fetch = FetchType.LAZY)
	private Collection<Evaluation> evaluations;
	private static final long serialVersionUID = 1L;

	public Eleve(String nomMembre, String prenomMembre, String sexeMembre, int ageMembre, String adresseMembre,
			String statutMembre, String loginMembre, String passewordMembre, Date dateEmbauche,
			ParentEleve parentEleve) {
		super(nomMembre, prenomMembre, sexeMembre, ageMembre, adresseMembre, statutMembre, loginMembre, passewordMembre,
				dateEmbauche);
		this.parentEleve = parentEleve;
	}

	public Eleve() {
		super();
	}

	public ParentEleve getParentEleve() {
		return parentEleve;
	}

	public void setParentEleve(ParentEleve parentEleve) {
		this.parentEleve = parentEleve;
	}

//	public Collection<ListePresence> getListePresences() {
//		return ListePresences;
//	}

	public void setListePresences(Collection<ListePresence> listePresences) {
		ListePresences = listePresences;
	}

//	public Collection<Evaluation> getEvaluations() {
//		return evaluations;
//	}

	public void setEvaluations(Collection<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

}
