package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ga_infouh01 database table.
 * 
 */
@Entity
@Table(name = "ga_infouh01")
@NamedQuery(name = "SituationCivile.findAll", query = "SELECT g FROM SituationCivile g")
public class SituationCivile implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dateffet;
	private Date datefin;
	private String etat;
	private Identite identite;

	public SituationCivile() {
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
	public Date getDateffet() {
		return this.dateffet;
	}

	public void setDateffet(Date dateffet) {
		this.dateffet = dateffet;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@ManyToOne
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}