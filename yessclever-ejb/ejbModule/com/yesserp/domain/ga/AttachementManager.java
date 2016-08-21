package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the ga_attauh01 database table.
 * 
 */
@Entity
@Table(name="ga_attarh01")
@NamedQuery(name="AttachementManager.findAll", query="SELECT g FROM AttachementManager g")
public class AttachementManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Affectation affectationManager;
	private Long managdos;
	private String managnom;
	private String managpre;
	private Date datedeb;
	private Date datefin;
	private String typeRatt;
	private String numMat;

	public AttachementManager() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Long getManagdos() {
		return this.managdos;
	}

	public void setManagdos(Long managdos) {
		this.managdos = managdos;
	}


	public String getManagnom() {
		return this.managnom;
	}

	public void setManagnom(String managnom) {
		this.managnom = managnom;
	}


	public String getManagpre() {
		return this.managpre;
	}

	public void setManagpre(String managpre) {
		this.managpre = managpre;
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

	@ManyToOne
	@JoinColumn(name="affectat")
	public Affectation getAffectationManager() {
		return affectationManager;
	}


	public void setAffectationManager(Affectation affectationManager) {
		this.affectationManager = affectationManager;
	}


	public String getTypeRatt() {
		return typeRatt;
	}


	public void setTypeRatt(String typeRatt) {
		this.typeRatt = typeRatt;
	}


	public String getNumMat() {
		return numMat;
	}


	public void setNumMat(String numMat) {
		this.numMat = numMat;
	}

}