package com.school.management.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EDT
 *
 */
@Entity

public class EDT implements Serializable {

	   
	@Id
	private long idEdt;
	private Date dateEdt;
	@OneToMany(mappedBy="edt" ,fetch=FetchType.LAZY)
	private Collection<Seance> Seances;
	private static final long serialVersionUID = 1L;

	public EDT() {
		super();
	}   
	public long getIdEdt() {
		return this.idEdt;
	}

	public void setIdEdt(long idEdt) {
		this.idEdt = idEdt;
	}   
	public Date getDateEdt() {
		return this.dateEdt;
	}

	public void setDateEdt(Date dateEdt) {
		this.dateEdt = dateEdt;
	}
   
}
