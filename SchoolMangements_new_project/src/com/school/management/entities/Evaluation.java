package com.school.management.entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Evaluation
 *
 */
@Entity

public class Evaluation implements Serializable {

	   
	@Id
	private long idEval;
	private String typeEval;
	private int noteEval;
	private int coefEval;
	@ManyToOne
	@JoinColumn(name="idMatiere")
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name="idElv")
	private Eleve eleve;
	private static final long serialVersionUID = 1L;

	public Evaluation() {
		super();
	}   
	public long getIdEval() {
		return this.idEval;
	}

	public void setIdEval(long idEval) {
		this.idEval = idEval;
	}   
	public String getTypeEval() {
		return this.typeEval;
	}

	public void setTypeEval(String typeEval) {
		this.typeEval = typeEval;
	}   
	public int getNoteEval() {
		return this.noteEval;
	}

	public void setNoteEval(int noteEval) {
		this.noteEval = noteEval;
	}   
	public int getCoefEval() {
		return this.coefEval;
	}

	public void setCoefEval(int coefEval) {
		this.coefEval = coefEval;
	}
   
}
