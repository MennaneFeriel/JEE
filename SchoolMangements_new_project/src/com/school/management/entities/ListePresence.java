package com.school.management.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ListePresence
 *
 */
@Entity

public class ListePresence implements Serializable {

	@Id
	private long idListePresence;
	private boolean present;
	@ManyToOne
	@JoinColumn(name="idSeance")
	private Seance seance;
	@ManyToOne
	@JoinColumn(name="idElv")
	private Eleve eleve;
	private static final long serialVersionUID = 1L;

	public ListePresence() {
		super();
	}   
	public boolean getPresent() {
		return this.present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}   
	public long getIdListePresence() {
		return this.idListePresence;
	}

	public void setIdListePresence(long idListePresence) {
		this.idListePresence = idListePresence;
	}
   
}
