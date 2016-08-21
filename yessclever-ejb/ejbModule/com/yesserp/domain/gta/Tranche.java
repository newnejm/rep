package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Tranche
 * 
 */
@Entity
@Table(name = "gta_tranche")
public class Tranche implements Serializable {

	private int idTranche;
	private boolean isAbsent;
	private Date date;
	private Absence absence;
	private static final long serialVersionUID = 1L;

	public Tranche() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdTranche() {
		return this.idTranche;
	}

	public void setIdTranche(int idTranche) {
		this.idTranche = idTranche;
	}

	@ManyToOne
	@JoinColumn(name = "absence_fk")
	public Absence getAbsence() {
		return absence;
	}

	public void setAbsence(Absence absence) {
		this.absence = absence;
	}

	public boolean isAbsent() {
		return isAbsent;
	}

	public void setAbsent(boolean isAbsent) {
		this.isAbsent = isAbsent;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
