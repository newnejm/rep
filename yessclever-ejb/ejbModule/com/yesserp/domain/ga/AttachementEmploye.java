package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the ga_attarh01 database table.
 * 
 */
@Entity
@Table(name="ga_attarh02")
@NamedQuery(name="AttachementEmploye.findAll", query="SELECT g FROM AttachementEmploye g")
public class AttachementEmploye implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Affectation affectea;
	private Long empdossi;
	private String empnom;
	private String emppreno;
	private Date datefin;
	private Date datedeb;
	private String typeRatt;
	private String numMat;

	public AttachementEmploye() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
	@Column(columnDefinition = "serial")
	public Long getEmpdossi() {
		return this.empdossi;
	}

	public void setEmpdossi(Long empdossi) {
		this.empdossi = empdossi;
	}


	public String getEmpnom() {
		return this.empnom;
	}

	public void setEmpnom(String empnom) {
		this.empnom = empnom;
	}


	public String getEmppreno() {
		return this.emppreno;
	}

	public void setEmppreno(String emppreno) {
		this.emppreno = emppreno;
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
	@JoinColumn(name="affectea")
	public Affectation getAffectea() {
		return affectea;
	}


	public void setAffectea(Affectation affectea) {
		this.affectea = affectea;
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