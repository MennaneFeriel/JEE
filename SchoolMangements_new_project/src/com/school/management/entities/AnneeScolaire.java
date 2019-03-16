package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.*;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AnneeScolaire
 *
 */
@Entity

public class AnneeScolaire implements Serializable {

	   
	@Id
	private long idAnneeScolaire;
	private String nomAnneeScolaire;
	private Date dateCreation;
	@OneToMany(mappedBy="anneeScolaire" ,fetch=FetchType.LAZY)
	private Collection<Cycle> cycles;
	private static final long serialVersionUID = 1L;

	public AnneeScolaire() {
		super();
	}   
	public long getIdAnneeScolaire() {
		return this.idAnneeScolaire;
	}

	public void setIdAnneeScolaire(long idAnneeScolaire) {
		this.idAnneeScolaire = idAnneeScolaire;
	}   
	public String getNomAnneeScolaire() {
		return this.nomAnneeScolaire;
	}

	public void setNomAnneeScolaire(String nomAnneeScolaire) {
		this.nomAnneeScolaire = nomAnneeScolaire;
	}   
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
   
}
