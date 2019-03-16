package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cycle
 *
 */
@Entity

public class Cycle implements Serializable {

	   
	@Id
	private long idCycle;
	private String nomCycle;
	@OneToMany(mappedBy="cycle" ,fetch=FetchType.LAZY)
	private Collection<Section> sections;
	@ManyToOne
	@JoinColumn(name="idAnneeScolaire")
	private AnneeScolaire anneeScolaire;
	private static final long serialVersionUID = 1L;

	public Cycle() {
		super();
	}   
	public long getIdCycle() {
		return this.idCycle;
	}

	public void setIdCycle(long idCycle) {
		this.idCycle = idCycle;
	}   
	public String getNomCycle() {
		return this.nomCycle;
	}

	public void setNomCycle(String nomCycle) {
		this.nomCycle = nomCycle;
	}
   
}
