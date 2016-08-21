package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: HoraireDeReferenceAbsence
 * 
 */
@Entity
public class HoraireDeReferenceAbsence implements Serializable {

	private int id;
	private Date heureDeb;
	private Date heureFin;
	private JourneeType journeeType;
	private static final long serialVersionUID = 1L;

	public HoraireDeReferenceAbsence() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeureDeb() {
		return this.heureDeb;
	}

	public void setHeureDeb(Date heureDeb) {
		this.heureDeb = heureDeb;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeureFin() {
		return this.heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	@ManyToOne
	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

}
