package com.yesserp.domain.ga;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the ga_contuh02 database table.
 * 
 */
@Entity
@Table(name="ga_contuh02")
@NamedQuery(name="Cycle.findAll", query="SELECT g FROM Cycle g")
public class Cycle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dateeffe;
	private Date datefin;
	private String typecycl;
	private Identite identite;

	public Cycle() {
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


	public String getTypecycl() {
		return this.typecycl;
	}

	public void setTypecycl(String typecycl) {
		this.typecycl = typecycl;
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