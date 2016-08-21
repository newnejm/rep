package com.yesserp.domain.ga;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the ga_infouf01 database table.
 * 
 */
@Entity
@Table(name = "ga_infouf01")
@NamedQuery(name = "InfosIndividuelles.findAll", query = "SELECT g FROM InfosIndividuelles g")
public class InfosIndividuelles implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String cin;
	private Identite identite;
	private String numpassp;
	private String numpermi;

	public InfosIndividuelles() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToOne
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public String getNumpassp() {
		return this.numpassp;
	}

	public void setNumpassp(String numpassp) {
		this.numpassp = numpassp;
	}

	public String getNumpermi() {
		return this.numpermi;
	}

	public void setNumpermi(String numpermi) {
		this.numpermi = numpermi;
	}

}