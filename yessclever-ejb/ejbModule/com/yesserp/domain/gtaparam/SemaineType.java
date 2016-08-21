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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.gta.CalculGta;
import com.yesserp.domain.gta.ExceptionSemaineType;
import com.yesserp.domain.gta.PlanningReel;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: SemaineType
 * 
 */
@Entity
@Table(name = "GTA_STP_RH01")
public class SemaineType implements Serializable {

	private int idst;
	private String codest;
	private Date dateff;
	private List<CodeJour> codeJours;
	private List<CycleTravail> cycleTravails;
	private List<Libelle> libelles;
	private List<SemaineJournees> semaineJournees;
	private List<ExceptionSemaineType> exceptionSemaineTypes;
	private List<PlanningReel> planningReels;
	private List<CalculGta> calculGtas;
	private CodeGTA codeGTA ;
	private List<DescSemaineType> descSemaineTypes;
	
	private List<SemaineTypeDescCycleTravail> semaineTypeDescCycleTravails ;
	
	private static final long serialVersionUID = 1L;

	public SemaineType() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdst() {
		return this.idst;
	}

	public void setIdst(int idst) {
		this.idst = idst;
	}

	public String getCodest() {
		return this.codest;
	}

	public void setCodest(String codest) {
		this.codest = codest;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateff() {
		return this.dateff;
	}

	public void setDateff(Date dateff) {
		this.dateff = dateff;
	}

	@ManyToMany
	@JoinTable(name = "GTA_STP_CJP_UF01")
	public List<CodeJour> getCodeJours() {
		return codeJours;
	}

	public void setCodeJours(List<CodeJour> codeJours) {
		this.codeJours = codeJours;
	}

	@ManyToMany(mappedBy = "semaineTypes")
	public List<CycleTravail> getCycleTravails() {
		return cycleTravails;
	}

	public void setCycleTravails(List<CycleTravail> cycleTravails) {
		this.cycleTravails = cycleTravails;
	}

	@OneToMany(mappedBy = "semaineType",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@OneToMany(mappedBy = "semaineType")
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
		result = prime * result + ((codest == null) ? 0 : codest.hashCode());
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
		SemaineType other = (SemaineType) obj;
		if (codest == null) {
			if (other.codest != null)
				return false;
		} else if (!codest.equals(other.codest))
			return false;
		return true;
	}

	@OneToMany(mappedBy = "semaineType", cascade = CascadeType.REMOVE)
	public List<SemaineJournees> getSemaineJournees() {
		return semaineJournees;
	}

	public void setSemaineJournees(List<SemaineJournees> semaineJournees) {
		this.semaineJournees = semaineJournees;
	}

	@OneToMany(mappedBy = "semaineType")
	public List<ExceptionSemaineType> getExceptionSemaineTypes() {
		return exceptionSemaineTypes;
	}

	public void setExceptionSemaineTypes(
			List<ExceptionSemaineType> exceptionSemaineTypes) {
		this.exceptionSemaineTypes = exceptionSemaineTypes;
	}

	@OneToMany(mappedBy = "semaineType")
	public List<CalculGta> getCalculGtas() {
		return calculGtas;
	}

	public void setCalculGtas(List<CalculGta> calculGtas) {
		this.calculGtas = calculGtas;
	}
	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}
	@OneToMany(mappedBy = "semaineType", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public List<DescSemaineType> getDescSemaineTypes() {
		return descSemaineTypes;
	}

	public void setDescSemaineTypes(List<DescSemaineType> descSemaineTypes) {
		this.descSemaineTypes = descSemaineTypes;
	}
	
	
	@OneToMany(mappedBy = "semaineType")
	public List<SemaineTypeDescCycleTravail> getSemaineTypeDescCycleTravails() {
		return semaineTypeDescCycleTravails;
	}

	public void setSemaineTypeDescCycleTravails(
			List<SemaineTypeDescCycleTravail> semaineTypeDescCycleTravails) {
		this.semaineTypeDescCycleTravails = semaineTypeDescCycleTravails;
	}

	
	
}
