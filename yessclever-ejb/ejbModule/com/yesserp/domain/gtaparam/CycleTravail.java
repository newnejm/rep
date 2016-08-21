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

import com.yesserp.domain.gta.AffectationCycle;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: CycleTravail
 * 
 */
@Entity
@Table(name = "GTA_CTP_UH01")
public class CycleTravail implements Serializable {

	private int idct;
	private String codect;
	private Date dateff;
	private Date dateFin;
	private String typeCycle;
	private List<JourneeType> journeeTypes;
	private List<CycleTravailAssociateJourneeType> cycleTravailAssociateJourneeTypes;
	private List<SemaineType> semaineTypes;
	private List<Libelle> libelles;
	private static final long serialVersionUID = 1L;
	private List<AffectationCycle> affectationCycles;
	private CodeGTA codeGTA ;
	
	
	private List<DescCycleTravail> descCycleTravails;

	public CycleTravail() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdct() {
		return this.idct;
	}

	public void setIdct(int idct) {
		this.idct = idct;
	}

	public String getCodect() {
		return this.codect;
	}

	public void setCodect(String codect) {
		this.codect = codect;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDateff() {
		return this.dateff;
	}

	public void setDateff(Date dateff) {
		this.dateff = dateff;
	}

	@ManyToMany
	@JoinTable(name = "GTA_CTP_STP_RH01")
	public List<SemaineType> getSemaineTypes() {
		return semaineTypes;
	}

	public void setSemaineTypes(List<SemaineType> semaineTypes) {
		this.semaineTypes = semaineTypes;
	}

	@OneToMany(mappedBy = "cycleTravail", cascade=CascadeType.ALL)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}



	@Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@OneToMany(mappedBy="cycleTravailGTA")
	public List<AffectationCycle> getAffectationCycles() {
		return affectationCycles;
	}

	public void setAffectationCycles(List<AffectationCycle> affectationCycles) {
		this.affectationCycles = affectationCycles;
	}

	public String getTypeCycle() {
		return typeCycle;
	}

	public void setTypeCycle(String typeCycle) {
		this.typeCycle = typeCycle;
	}


	@OneToMany(mappedBy ="cycleTravail")
	public List<CycleTravailAssociateJourneeType> getCycleTravailAssociateJourneeTypes() {
		return cycleTravailAssociateJourneeTypes;
	}

	public void setCycleTravailAssociateJourneeTypes(
			List<CycleTravailAssociateJourneeType> cycleTravailAssociateJourneeTypes) {
		this.cycleTravailAssociateJourneeTypes = cycleTravailAssociateJourneeTypes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((affectationCycles == null) ? 0 : affectationCycles
						.hashCode());
		result = prime * result + ((codect == null) ? 0 : codect.hashCode());
		result = prime
				* result
				+ ((cycleTravailAssociateJourneeTypes == null) ? 0
						: cycleTravailAssociateJourneeTypes.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((dateff == null) ? 0 : dateff.hashCode());
		result = prime * result + idct;
		result = prime * result
				+ ((journeeTypes == null) ? 0 : journeeTypes.hashCode());
		result = prime * result
				+ ((libelles == null) ? 0 : libelles.hashCode());
		result = prime * result
				+ ((semaineTypes == null) ? 0 : semaineTypes.hashCode());
		result = prime * result
				+ ((typeCycle == null) ? 0 : typeCycle.hashCode());
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
		CycleTravail other = (CycleTravail) obj;
		if (affectationCycles == null) {
			if (other.affectationCycles != null)
				return false;
		} else if (!affectationCycles.equals(other.affectationCycles))
			return false;
		if (codect == null) {
			if (other.codect != null)
				return false;
		} else if (!codect.equals(other.codect))
			return false;
		if (cycleTravailAssociateJourneeTypes == null) {
			if (other.cycleTravailAssociateJourneeTypes != null)
				return false;
		} else if (!cycleTravailAssociateJourneeTypes
				.equals(other.cycleTravailAssociateJourneeTypes))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (dateff == null) {
			if (other.dateff != null)
				return false;
		} else if (!dateff.equals(other.dateff))
			return false;
		if (idct != other.idct)
			return false;
		if (journeeTypes == null) {
			if (other.journeeTypes != null)
				return false;
		} else if (!journeeTypes.equals(other.journeeTypes))
			return false;
		if (libelles == null) {
			if (other.libelles != null)
				return false;
		} else if (!libelles.equals(other.libelles))
			return false;
		if (semaineTypes == null) {
			if (other.semaineTypes != null)
				return false;
		} else if (!semaineTypes.equals(other.semaineTypes))
			return false;
		if (typeCycle == null) {
			if (other.typeCycle != null)
				return false;
		} else if (!typeCycle.equals(other.typeCycle))
			return false;
		return true;
	}

	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

	
	@OneToMany(mappedBy = "cycleTravail", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	public List<DescCycleTravail> getDescCycleTravails() {
		return descCycleTravails;
	}

	public void setDescCycleTravails(List<DescCycleTravail> descCycleTravails) {
		this.descCycleTravails = descCycleTravails;
	}

	


}
