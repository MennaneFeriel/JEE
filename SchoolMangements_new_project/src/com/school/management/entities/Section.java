package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Section
 *
 */
@Entity

public class Section implements Serializable {

	   
	@Id
	private long idSession;
	private String nomSession;
	@OneToMany(mappedBy="section" ,fetch=FetchType.LAZY)
	private Collection<NiveauEtude> niveauEtudes;
	@ManyToOne
	@JoinColumn(name="idCycle")
	private Cycle cycle;
	private static final long serialVersionUID = 1L;

	public Section() {
		super();
	}   
	public long getIdSession() {
		return this.idSession;
	}

	public void setIdSession(long idSession) {
		this.idSession = idSession;
	}   
	public String getNomSession() {
		return this.nomSession;
	}

	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}
   
}
