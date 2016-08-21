package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gta.CalculGta;
import com.yesserp.domain.gta.Exceptionjournee;
import com.yesserp.domain.gta.PlanningReel;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: JourneeType
 * 
 */
@Entity
@Table(name = "GTA_JTP_UF01")
public class JourneeType implements Serializable {

	private Integer idjt;
	private String codejt;
	private Date dateff;
	private Integer poids;
	private String typeJournee;
	private List<Filtre> filtres;
	private List<Libelle> libelles;
	private List<PlageHoraireAssociateJourneeType> plageHoraireAssociateJourneeTypes;
	private List<CycleTravailAssociateJourneeType> cycleTravailAssociateJourneeTypes;
	private List<SemaineJournees> semaineJournees;
	private List<HoraireDeReference> horaireDeReferences;
	private List<HoraireDeReferenceAbsence> horaireDeReferenceAbsences;
	private List<Exceptionjournee> exceptionsjournees;
	private List<PlanningReel> planningReels;
	private List<CalculGta> calculGtas;
	private List<DescJourneeType> descJourneeTypes;
	private CodeGTA codeGTA;
	private List<JourneeTypeDescSemaineType> journeeTypeDescSemaineTypes;
	private List<JourneeTypeDescCycleTravail> journeeTypeDescCycleTravail;
	
	private List<DescJourneeType> testdescJourneeTypes ;
	private static final long serialVersionUID = 1L;

	public JourneeType() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdjt() {
		return this.idjt;
	}

	public void setIdjt(Integer idjt) {
		this.idjt = idjt;
	}

	public String getTypeJournee() {
		return typeJournee;
	}

	public void setTypeJournee(String typeJournee) {
		this.typeJournee = typeJournee;
	}

	public String getCodejt() {
		return this.codejt;
	}

	public void setCodejt(String codejt) {
		this.codejt = codejt;
	}

	public Date getDateff() {
		return this.dateff;
	}

	public void setDateff(Date dateff) {
		this.dateff = dateff;
	}

	public Integer getPoids() {
		return this.poids;
	}

	public void setPoids(Integer poids) {
		this.poids = poids;
	}

	@ManyToMany(mappedBy = "journeeTypes")
	public List<Filtre> getFiltres() {
		return filtres;
	}

	public void setFiltres(List<Filtre> filtres) {
		this.filtres = filtres;
	}

	@OneToMany(mappedBy = "journeeType", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@OneToMany(mappedBy = "journeeType")
	public List<PlageHoraireAssociateJourneeType> getPlageHoraireAssociateJourneeTypes() {
		return plageHoraireAssociateJourneeTypes;
	}

	public void setPlageHoraireAssociateJourneeTypes(
			List<PlageHoraireAssociateJourneeType> plageHoraireAssociateJourneeTypes) {
		this.plageHoraireAssociateJourneeTypes = plageHoraireAssociateJourneeTypes;
	}

	@OneToMany(mappedBy = "journeeType")
	public List<SemaineJournees> getSemaineJournees() {
		return semaineJournees;
	}

	public void setSemaineJournees(List<SemaineJournees> semaineJournees) {
		this.semaineJournees = semaineJournees;
	}

	@OneToMany(mappedBy = "journeeType")
	public List<HoraireDeReference> getHoraireDeReferences() {
		return horaireDeReferences;
	}

	public void setHoraireDeReferences(
			List<HoraireDeReference> horaireDeReferences) {
		this.horaireDeReferences = horaireDeReferences;
	}

	@OneToMany(mappedBy = "journeeTypeApres")
	public List<Exceptionjournee> getExceptionsjournees() {
		return exceptionsjournees;
	}

	public void setExceptionsjournees(List<Exceptionjournee> exceptionsjournees) {
		this.exceptionsjournees = exceptionsjournees;
	}

	@OneToMany(mappedBy = "journeeType")
	public List<PlanningReel> getPlanningReels() {
		return planningReels;
	}

	public void setPlanningReels(List<PlanningReel> planningReels) {
		this.planningReels = planningReels;
	}

	@OneToMany(mappedBy = "journeeType")
	public List<HoraireDeReferenceAbsence> getHoraireDeReferenceAbsences() {
		return horaireDeReferenceAbsences;
	}

	public void setHoraireDeReferenceAbsences(
			List<HoraireDeReferenceAbsence> horaireDeReferenceAbsences) {
		this.horaireDeReferenceAbsences = horaireDeReferenceAbsences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codejt == null) ? 0 : codejt.hashCode());
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
		JourneeType other = (JourneeType) obj;
		if (codejt == null) {
			if (other.codejt != null)
				return false;
		} else if (!codejt.equals(other.codejt))
			return false;
		return true;
	}

	@OneToMany(mappedBy = "journeeType")
	public List<CalculGta> getCalculGtas() {
		return calculGtas;
	}

	public void setCalculGtas(List<CalculGta> calculGtas) {
		this.calculGtas = calculGtas;
	}

	@OneToMany(mappedBy = "journeeType")
	public List<CycleTravailAssociateJourneeType> getCycleTravailAssociateJourneeTypes() {
		return cycleTravailAssociateJourneeTypes;
	}

	public void setCycleTravailAssociateJourneeTypes(
			List<CycleTravailAssociateJourneeType> cycleTravailAssociateJourneeTypes) {
		this.cycleTravailAssociateJourneeTypes = cycleTravailAssociateJourneeTypes;
	}

	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

	@OneToMany(mappedBy = "journeeType", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	public List<DescJourneeType> getDescJourneeTypes() {
		return descJourneeTypes;
	}

	public void setDescJourneeTypes(List<DescJourneeType> descJourneeTypes) {
		this.descJourneeTypes = descJourneeTypes;
	}

    @OneToMany(mappedBy="testjourneeType2")
	public List<DescJourneeType> getTestdescJourneeTypes() {
		return testdescJourneeTypes;
	}

	public void setTestdescJourneeTypes(List<DescJourneeType> testdescJourneeTypes) {
		this.testdescJourneeTypes = testdescJourneeTypes;
	}

	
	
	
	@OneToMany(mappedBy = "journeeType", cascade = CascadeType.ALL)
	public List<JourneeTypeDescSemaineType> getJourneeTypeDescSemaineTypes() {
		return journeeTypeDescSemaineTypes;
	}

	public void setJourneeTypeDescSemaineTypes(
			List<JourneeTypeDescSemaineType> journeeTypeDescSemaineTypes) {
		this.journeeTypeDescSemaineTypes = journeeTypeDescSemaineTypes;
	}

	@OneToMany(mappedBy = "journeeType", cascade = CascadeType.REMOVE)
	public List<JourneeTypeDescCycleTravail> getJourneeTypeDescCycleTravails() {
		return journeeTypeDescCycleTravail;
	}

	public void setJourneeTypeDescCycleTravails(
			List<JourneeTypeDescCycleTravail> journeeTypeDescCycleTravails) {
		this.journeeTypeDescCycleTravail = journeeTypeDescCycleTravails;
	}


	
	


	
	
	
	
	
	
}
