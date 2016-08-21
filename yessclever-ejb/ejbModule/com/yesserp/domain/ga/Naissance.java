package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Naissance
 * 
 */
@Entity
@Table(name = "ga_naisuf01")
public class Naissance implements Serializable {

	private Long id;
	private Date datenais;
	private String villnais;
	private String deptnais;
	private String pays;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public Naissance() {
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

	@Temporal(TemporalType.DATE)
	public Date getDatenais() {
		return datenais;
	}

	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}

	public String getVillnais() {
		return villnais;
	}

	public void setVillnais(String villnais) {
		this.villnais = villnais;
	}

	public String getDeptnais() {
		return deptnais;
	}

	public void setDeptnais(String deptnais) {
		this.deptnais = deptnais;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@OneToOne
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

}
