package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Salle
 *
 */
@Entity

public class Salle implements Serializable {  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSall;
	private String nomSalle;
	private int capaciteSalle;
	private boolean etatSalle;
	@ManyToOne
	@JoinColumn(name="idEtage")
	private Etage etage;
	@OneToOne(cascade = CascadeType.ALL)
	private Seance  seance;
	private static final long serialVersionUID = 1L;
   
	public Salle() {
		super();
	}  
	
	public int getCapaciteSalle() {
		return capaciteSalle;
	}

	public void setCapaciteSalle(int capaciteSalle) {
		this.capaciteSalle = capaciteSalle;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Etage getEtage() {
		return etage;
	}
	public void setEtage(Etage etage) {
		this.etage = etage;
	}
	 
	public long getIdSall() {
		return this.idSall;
	}

	public void setIdSall(long idSall) {
		this.idSall = idSall;
	}   
	public String getNomSalle() {
		return this.nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}   
	public boolean getEtatSalle() {
		return this.etatSalle;
	}

	public void setEtatSalle(boolean etatSalle) {
		this.etatSalle = etatSalle;
	}
   
}
