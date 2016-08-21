package com.yesserp.domain.ga;

import java.io.Serializable;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ga_embauh01 database table.
 * 
 */
@Entity
@Table(name = "ga_embauh01")
@NamedQuery(name = "Embauche.findAll", query = "SELECT g FROM Embauche g")
public class Embauche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date datedeb;
	private Date datefin;
	private String valide;
	private Date finessai;
	private String periodeEssai;
	private Identite identite;
	private List<Salaire> salaires;
	private List<Affectation> affectations;
	private List<Contrat> contrats;

	public Embauche() {
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

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	@OneToMany(mappedBy = "embauche", cascade = CascadeType.REMOVE)
	public List<Salaire> getSalaires() {
		return salaires;
	}

	public void setSalaires(List<Salaire> salaires) {
		this.salaires = salaires;
	}

	@OneToMany(mappedBy = "embauche", cascade = CascadeType.REMOVE)
	public List<Affectation> getAffectations() {
		return affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFinessai() {
		return finessai;
	}

	public void setFinessai(Date finessai) {
		this.finessai = finessai;
	}

	@Column(name = "peressai")
	public String getPeriodeEssai() {
		return periodeEssai;
	}

	public void setPeriodeEssai(String periodeEssai) {
		this.periodeEssai = periodeEssai;
	}

	@OneToMany(mappedBy = "embauche", cascade = CascadeType.REMOVE)
	public List<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public String getValide() {
		return valide;
	}

	public void setValide(String valide) {
		this.valide = valide;
	}
}