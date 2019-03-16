package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Batiment
 *
 */
@Entity

public class Batiment implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idBat;
	private String nomBat;
	private int nombrEtages;
	@OneToMany(mappedBy="batiment" ,fetch=FetchType.LAZY)
	private Collection<Etage> etages;
	private static final long serialVersionUID = 1L;

	public Batiment(String nomBat, int nombrEtages, Collection<Etage> etages) {
		super();
		this.nomBat = nomBat;
		this.nombrEtages = nombrEtages;
		this.etages = etages;
	}
	public Batiment() {
		super();
	}   
	public long getIdBat() {
		return this.idBat;
	}

	public void setIdBat(long idBat) {
		this.idBat = idBat;
	}   
	public String getNomBat() {
		return this.nomBat;
	}

	public void setNomBat(String nomBat) {
		this.nomBat = nomBat;
	}   
	public int getNombrEtages() {
		return this.nombrEtages;
	}

	public void setNombrEtages(int nombrEtages) {
		this.nombrEtages = nombrEtages;
	}
	public Collection<Etage> getEtages() {
		return etages;
	}
	public void setEtages(Collection<Etage> etages) {
		this.etages = etages;
	}
   
}
