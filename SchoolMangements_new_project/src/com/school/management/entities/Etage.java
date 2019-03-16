package com.school.management.entities;
import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Etage
 *
 */
@Entity

public class Etage implements Serializable {   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEtage;
	private String nomEtage;
	private int nombreSalles;
	@OneToMany(mappedBy="etage" ,fetch=FetchType.LAZY)
	private Collection<Salle> salles;
	@ManyToOne
	@JoinColumn(name="idBat")
	private Batiment batiment;
	private static final long serialVersionUID = 1L;

	public Etage() {
		super();
	}   
	public long getIdEtage() {
		return this.idEtage;
	}

	public void setIdEtage(long idEtage) {
		this.idEtage = idEtage;
	}   
	public String getNomEtage() {
		return this.nomEtage;
	}

	public void setNomEtage(String nomEtage) {
		this.nomEtage = nomEtage;
	}   
	public int getNombreSalles() {
		return this.nombreSalles;
	}

	public void setNombreSalles(int nombreSalles) {
		this.nombreSalles = nombreSalles;
	}
   
}
