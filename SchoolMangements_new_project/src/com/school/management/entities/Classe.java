package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Classe
 *
 */
@Entity

public class Classe implements Serializable {

	   
	@Id
	private long idClass;
	private String nomClasse;
	private Date dateDajout;
	private int nombreEleve;
	@OneToOne(cascade = CascadeType.ALL)
	private Seance seance;
	@ManyToOne
	@JoinColumn(name="idNiveauEtude")
	private NiveauEtude niveauEtude;
	private static final long serialVersionUID = 1L;

	public Classe() {
		super();
	}   
	public long getIdClass() {
		return this.idClass;
	}

	public void setIdClass(long idClass) {
		this.idClass = idClass;
	}   
	public String getNomClasse() {
		return this.nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}   
	public Date getDateDajout() {
		return this.dateDajout;
	}

	public void setDateDajout(Date dateDajout) {
		this.dateDajout = dateDajout;
	}   
	public int getNombreEleve() {
		return this.nombreEleve;
	}

	public void setNombreEleve(int nombreEleve) {
		this.nombreEleve = nombreEleve;
	}
   
}
