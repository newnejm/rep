package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gta.ExceptionPlageHoraire;
import com.yesserp.domain.gta.PlanningReel;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: PlageHoraire
 * 
 */
@Entity
@Table(name = "GTA_PHP_UH01")
public class PlageHoraire implements Serializable {

	private Integer idph;
	private String codeph;
	private String typePlage;
	private Date entreePlage;
	private Date sortiePlage;
	private static final long serialVersionUID = 1L;
	private ActiviteAbsence activiteAbsence;
	private ActivitePresence activitePresence;
	private ActiviteAbsence acAbsenceEntree;
	private ActiviteAbsence acAbsenceSortie;

	private List<PlanningReel> planningReels;

	private List<PlageHoraireAssociateJourneeType> plageHoraireAssociateJourneeTypes;
	private List<ExceptionPlageHoraire> exceptionPlageHoraires;
	private List<Libelle> libelles;
	private CodeGTA codeGTA;
	private List<PlageHoraireDescJourneeType> plageHoraireDescJourneeTypes;

	public PlageHoraire() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdph() {
		return this.idph;
	}

	public void setIdph(Integer idph) {
		this.idph = idph;
	}

	public Date getEntreePlage() {
		return entreePlage;
	}

	public void setEntreePlage(Date entreePlage) {
		this.entreePlage = entreePlage;
	}

	public Date getSortiePlage() {
		return sortiePlage;
	}

	public void setSortiePlage(Date sortiePlage) {
		this.sortiePlage = sortiePlage;
	}

	public String getCodeph() {
		return this.codeph;
	}

	public void setCodeph(String codeph) {
		this.codeph = codeph;
	}

	@OneToMany(mappedBy = "plageHoraire")
	public List<PlageHoraireAssociateJourneeType> getPlageHoraireAssociateJourneeTypes() {
		return plageHoraireAssociateJourneeTypes;
	}

	public void setPlageHoraireAssociateJourneeTypes(
			List<PlageHoraireAssociateJourneeType> plageHoraireAssociateJourneeTypes) {
		this.plageHoraireAssociateJourneeTypes = plageHoraireAssociateJourneeTypes;
	}

	@ManyToOne
	public ActiviteAbsence getActiviteAbsence() {
		return activiteAbsence;
	}

	public void setActiviteAbsence(ActiviteAbsence activiteAbsence) {
		this.activiteAbsence = activiteAbsence;
	}

	@ManyToOne
	public ActivitePresence getActivitePresence() {
		return activitePresence;
	}

	public void setActivitePresence(ActivitePresence activitePresence) {
		this.activitePresence = activitePresence;
	}

	public String getTypePlage() {
		return typePlage;
	}

	public void setTypePlage(String typePlage) {
		this.typePlage = typePlage;
	}

	@OneToMany(mappedBy = "plageHoraire")
	public List<PlanningReel> getPlanningReels() {
		return planningReels;
	}

	public void setPlanningReels(List<PlanningReel> planningReels) {
		this.planningReels = planningReels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeph == null) ? 0 : codeph.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlageHoraire other = (PlageHoraire) obj;
		if (codeph == null) {
			if (other.codeph != null)
				return false;
		} else if (!codeph.equals(other.codeph))
			return false;
		return true;
	}

	@OneToMany(mappedBy = "plageHoraire")
	public List<ExceptionPlageHoraire> getExceptionPlageHoraires() {
		return exceptionPlageHoraires;
	}

	public void setExceptionPlageHoraires(
			List<ExceptionPlageHoraire> exceptionPlageHoraires) {
		this.exceptionPlageHoraires = exceptionPlageHoraires;
	}

	@OneToMany(mappedBy = "plageHoraire", cascade = CascadeType.ALL)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	public ActiviteAbsence getAcAbsenceEntree() {
		return acAbsenceEntree;
	}

	public void setAcAbsenceEntree(ActiviteAbsence acAbsenceEntree) {
		this.acAbsenceEntree = acAbsenceEntree;
	}

	public ActiviteAbsence getAcAbsenceSortie() {
		return acAbsenceSortie;
	}

	public void setAcAbsenceSortie(ActiviteAbsence acAbsenceSortie) {
		this.acAbsenceSortie = acAbsenceSortie;
	}

	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

	@OneToMany(mappedBy = "plageHoraire")
	public List<PlageHoraireDescJourneeType> getPlageHoraireDescJourneeTypes() {
		return plageHoraireDescJourneeTypes;
	}

	public void setPlageHoraireDescJourneeTypes(
			List<PlageHoraireDescJourneeType> plageHoraireDescJourneeTypes) {
		this.plageHoraireDescJourneeTypes = plageHoraireDescJourneeTypes;
	}

}
