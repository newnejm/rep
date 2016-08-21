package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
 * The persistent class for the ga_afferh01 database table.
 * 
 */
@Entity
@Table(name = "ga_afferh01")
@NamedQuery(name = "Affectation.findAll", query = "SELECT g FROM Affectation g")
public class Affectation implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date datedeb;
	private Date datefin;
	private String categori;
	private String motif;
	private String emploi;
	private String poste;
	private String uniteorga;
	private Double pctaffec;
	// modalité de service
	private String tempserv;
	private String quotidie;
	private String hebdo;
	private String mensuel;
	private Double pctplain;
	private Embauche embauche;
	private List<AttachementEmploye> attachementEmployes;
	private List<AttachementManager> attachementManagers;
	private List<ImputationGa> imputationsGa;
	public Affectation() {
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

	public String getPoste() {
		return this.poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getUniteorga() {
		return this.uniteorga;
	}

	public void setUniteorga(String uniteorga) {
		this.uniteorga = uniteorga;
	}

	@ManyToOne
	@JoinColumn(name = "embauche")
	public Embauche getEmbauche() {
		return embauche;
	}

	public void setEmbauche(Embauche embauche) {
		this.embauche = embauche;
	}

	@OneToMany(mappedBy = "affectea", cascade = CascadeType.REMOVE)
	public List<AttachementEmploye> getAttachementEmployes() {
		return attachementEmployes;
	}

	public void setAttachementEmployes(
			List<AttachementEmploye> attachementEmployes) {
		this.attachementEmployes = attachementEmployes;
	}

	@OneToMany(mappedBy = "affectationManager", cascade = CascadeType.REMOVE)
	public List<AttachementManager> getAttachementManagers() {
		return attachementManagers;
	}

	public void setAttachementManagers(
			List<AttachementManager> attachementManagers) {
		this.attachementManagers = attachementManagers;
	}

	public Double getPctaffec() {
		return pctaffec;
	}

	public void setPctaffec(Double pctaffec) {
		this.pctaffec = pctaffec;
	}

	public String getEmploi() {
		return emploi;
	}

	public void setEmploi(String emploi) {
		this.emploi = emploi;
	}

	public String getCategori() {
		return categori;
	}

	public void setCategori(String categori) {
		this.categori = categori;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getTempserv() {
		return tempserv;
	}

	public void setTempserv(String tempserv) {
		this.tempserv = tempserv;
	}

	
	public String getQuotidie() {
		return quotidie;
	}

	public void setQuotidie(String quotidie) {
		this.quotidie = quotidie;
	}

	public String getHebdo() {
		return hebdo;
	}

	public void setHebdo(String hebdo) {
		this.hebdo = hebdo;
	}

	public String getMensuel() {
		return mensuel;
	}

	public void setMensuel(String mensuel) {
		this.mensuel = mensuel;
	}

	public Double getPctplain() {
		return pctplain;
	}

	public void setPctplain(Double pctplain) {
		this.pctplain = pctplain;
	}

	@OneToMany(mappedBy = "affectation", cascade = CascadeType.REMOVE)
	public List<ImputationGa> getImputationsGa() {
		return imputationsGa;
	}

	public void setImputationsGa(List<ImputationGa> imputationsGa) {
		this.imputationsGa = imputationsGa;
	}

}