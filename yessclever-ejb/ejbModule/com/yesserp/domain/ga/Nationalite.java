package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Nationalite
 * 
 */
@Entity
@Table(name = "ga_natirh01")
public class Nationalite implements Serializable {

	private Long id;
	private Date datedeb;
	private Date datefin;
	private String pays;
	private boolean principa;
	private String modeAcquisition;
	private Identite identite;

	private static final long serialVersionUID = 1L;

	public Nationalite() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatedeb() {
		return this.datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public boolean isPrincipa() {
		return principa;
	}

	public void setPrincipa(boolean principa) {
		this.principa = principa;
	}

	@Column(name = "modeacqu")
	public String getModeAcquisition() {
		return modeAcquisition;
	}

	public void setModeAcquisition(String modeAcquisition) {
		this.modeAcquisition = modeAcquisition;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}	
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

}
