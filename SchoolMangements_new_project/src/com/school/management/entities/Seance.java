package com.school.management.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Seance
 *
 */
@Entity
public class Seance implements Serializable {   
	@Id
	private long idSeance;
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date heureDebut;
	private Date heureFin;
	private Date dateSeance;
	private boolean etatValide;
//	@OneToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="idSalle")
//	private Salle salle;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEns")
	private Enseignant enseignant;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idClasse")
	private Classe classe;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMatiere")
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name = "idEdt")
	private EDT edt;
	@OneToMany(mappedBy="seance" ,fetch=FetchType.LAZY)
	private Collection<ListePresence> ListePresences;
	private static final long serialVersionUID = 1L;

	public Seance() {
		super();
	}   
	public long getIdSeance() {
		return this.idSeance;
	}

	public void setIdSeance(long idSeance) {
		this.idSeance = idSeance;
	}   
	public Date getHeureDebut() {
		return this.heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}   
	public Date getHeureFin() {
		return this.heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}   
	public Date getDateSeance() {
		return this.dateSeance;
	}

	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
	}   
	public boolean getEtatValide() {
		return this.etatValide;
	}

	public void setEtatValide(boolean etatValide) {
		this.etatValide = etatValide;
	}
   
}
