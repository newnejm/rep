package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.yesserp.domain.gta.ExceptionPlageHoraire;
import com.yesserp.domain.gta.PlanningReel;
import com.yesserp.domain.pg.CodeGTA;



@Entity
public class PlageHoraire2 implements Serializable{
	
	private Integer idph2;
	private String  codeph ;
	private String typePlage ;
	private Date entreePlage ;
	private Date sortiePlage ;
	private static final long serialVersionUID =1L ;
	private ActiviteAbsence activiteAbsence ;
	private ActivitePresence activitePresence ;
	private ActiviteAbsence acAbsenceEntree ;
	private ActiviteAbsence acAbsenceSortie ;
	
//	private List<PlanningReel> planningReels;
	
	private List<PlageHoraireAssociateJourneeType2> plageHoraireAssociateJourneeTypes2 ;
//	private List<ExceptionPlageHoraire> exceptionPlageHoraires ;
	private List<Libelle> libelles ;
	private CodeGTA codeGTA ;
	private List<PlageHoraireDescJourneeType2> plageHoraireDescJourneeTypes2 ;
	
	public PlageHoraire2() {
		super();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer getIdph2() {
		return idph2;
	}

	public String getCodeph() {
		return codeph;
	}

	public String getTypePlage() {
		return typePlage;
	}

	public Date getEntreePlage() {
		return entreePlage;
	}

	public Date getSortiePlage() {
		return sortiePlage;
	}

	
	@OneToMany(mappedBy = "plageHoraire2")
	public List<PlageHoraireAssociateJourneeType2> getPlageHoraireAssociateJourneeTypes2() {
		return plageHoraireAssociateJourneeTypes2;
	}

	public void setPlageHoraireAssociateJourneeTypes2(
			List<PlageHoraireAssociateJourneeType2> plageHoraireAssociateJourneeTypes2) {
		this.plageHoraireAssociateJourneeTypes2 = plageHoraireAssociateJourneeTypes2;
	}

	public ActiviteAbsence getActiviteAbsence() {
		return activiteAbsence;
	}

	public ActivitePresence getActivitePresence() {
		return activitePresence;
	}

	public ActiviteAbsence getAcAbsenceEntree() {
		return acAbsenceEntree;
	}

	public ActiviteAbsence getAcAbsenceSortie() {
		return acAbsenceSortie;
	}
//
//	public List<PlanningReel> getPlanningReels() {
//		return planningReels;
//	}

//	public List<ExceptionPlageHoraire> getExceptionPlageHoraires() {
//		return exceptionPlageHoraires;
//	}

	
	@OneToMany(mappedBy = "plageHoraire2", cascade = CascadeType.ALL)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public CodeGTA getCodeGTA() {
		return codeGTA;
	}


@OneToMany(mappedBy = "plageHoraire2")
	public List<PlageHoraireDescJourneeType2> getPlageHoraireDescJourneeTypes2() {
		return plageHoraireDescJourneeTypes2;
	}

	public void setPlageHoraireDescJourneeTypes2(
			List<PlageHoraireDescJourneeType2> plageHoraireDescJourneeTypes2) {
		this.plageHoraireDescJourneeTypes2 = plageHoraireDescJourneeTypes2;
	}

	public void setIdph2(Integer idph2) {
		this.idph2 = idph2;
	}

	public void setCodeph(String codeph) {
		this.codeph = codeph;
	}

	public void setTypePlage(String typePlage) {
		this.typePlage = typePlage;
	}

	public void setEntreePlage(Date entreePlage) {
		this.entreePlage = entreePlage;
	}

	public void setSortiePlage(Date sortiePlage) {
		this.sortiePlage = sortiePlage;
	}

	public void setActiviteAbsence(ActiviteAbsence activiteAbsence) {
		this.activiteAbsence = activiteAbsence;
	}

	public void setActivitePresence(ActivitePresence activitePresence) {
		this.activitePresence = activitePresence;
	}

	public void setAcAbsenceEntree(ActiviteAbsence acAbsenceEntree) {
		this.acAbsenceEntree = acAbsenceEntree;
	}

	public void setAcAbsenceSortie(ActiviteAbsence acAbsenceSortie) {
		this.acAbsenceSortie = acAbsenceSortie;
	}

//	public void setPlanningReels(List<PlanningReel> planningReels) {
//		this.planningReels = planningReels;
//	}

//	public void setExceptionPlageHoraires(
//			List<ExceptionPlageHoraire> exceptionPlageHoraires) {
//		this.exceptionPlageHoraires = exceptionPlageHoraires;
//	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

//	public void setPlageHoraireDescJourneeTypes(
//			List<PlageHoraireDescJourneeType> plageHoraireDescJourneeTypes) {
//		this.plageHoraireDescJourneeTypes = plageHoraireDescJourneeTypes;
//	}
//	
	
	
	

}
