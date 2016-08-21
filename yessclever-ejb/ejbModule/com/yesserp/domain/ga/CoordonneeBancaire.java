package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
 * Entity implementation class for Entity: CoordonneeBancaire
 * 
 */
@Entity
@Table(name = "ga_bancuh01")
public class CoordonneeBancaire implements Serializable {

	private Long id;
	private String banque;
	private String codeBanque;
	private String codeAgence;
	private String libelleAgence;
	private String numcompt;
	private String cle;
	private String swift;
	private String iban;
	private String codepays;
	private Date dateffet;
	private Date datefin;
	private Identite identite;

	private static final long serialVersionUID = 1L;

	public CoordonneeBancaire() {
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

	public String getBanque() {
		return this.banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	@Column(name = "codagenc")
	public String getCodeAgence() {
		return this.codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	@Column(name = "libagenc")
	public String getLibelleAgence() {
		return this.libelleAgence;
	}

	public void setLibelleAgence(String libelleAgence) {
		this.libelleAgence = libelleAgence;
	}

	

	public String getSwift() {
		return this.swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getCodepays() {
		return this.codepays;
	}

	public void setCodepays(String codepays) {
		this.codepays = codepays;
	}

	@ManyToOne
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateffet() {
		return dateffet;
	}

	public void setDateffet(Date dateffet) {
		this.dateffet = dateffet;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getCodeBanque() {
		return codeBanque;
	}

	public void setCodeBanque(String codeBanque) {
		this.codeBanque = codeBanque;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getNumcompt() {
		return numcompt;
	}

	public void setNumcompt(String numcompt) {
		this.numcompt = numcompt;
	}

	public String getCle() {
		return cle;
	}

	public void setCle(String cle) {
		this.cle = cle;
	}

}
