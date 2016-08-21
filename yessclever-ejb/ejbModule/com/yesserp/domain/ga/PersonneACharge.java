package com.yesserp.domain.ga;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the ga_inforh01 database table.
 * 
 */
@Entity
@Table(name="ga_inforh01")
@NamedQuery(name="PersonneACharge.findAll", query="SELECT g FROM PersonneACharge g")
public class PersonneACharge implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String cin;
	private Date datenais;
	private byte[] justific;
	private String nom;
	private String prenom;
	private Date datedeb;
	private Date datefin;
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	private Identite identite;


	public PersonneACharge() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatenais() {
		return this.datenais;
	}

	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}



	public byte[] getJustific() {
		return this.justific;
	}

	public void setJustific(byte[] justific) {
		this.justific = justific;
	}


	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	@ManyToOne
	@JoinColumn(name="dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

}