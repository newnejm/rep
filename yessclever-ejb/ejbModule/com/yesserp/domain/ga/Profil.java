package com.yesserp.domain.ga;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the ga_contuh01 database table.
 * 
 */
@Entity
@Table(name="ga_contuh01")
@NamedQuery(name="Profil.findAll", query="SELECT g FROM Profil g")
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dateeffe;
	private Date datefin;	
	private String typeprof;
	private Identite identite;


	public Profil() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateeffe() {
		return this.dateeffe;
	}

	public void setDateeffe(Date dateeffe) {
		this.dateeffe = dateeffe;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getTypeprof() {
		return this.typeprof;
	}

	public void setTypeprof(String typeprof) {
		this.typeprof = typeprof;
	}
	
	@ManyToOne
	@JoinColumn(name="dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

}