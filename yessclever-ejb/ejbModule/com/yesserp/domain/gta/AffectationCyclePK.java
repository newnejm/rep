package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class AffectationCyclePK implements Serializable {

	private Long idIdentite;
	private int idCycle;
	private Date dateAffectation;

	public AffectationCyclePK() {
		super();
	}

	public Long getIdIdentite() {
		return idIdentite;
	}

	public void setIdIdentite(Long idIdentite) {
		this.idIdentite = idIdentite;
	}

	public int getIdCycle() {
		return idCycle;
	}

	public void setIdCycle(int idCycle) {
		this.idCycle = idCycle;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateAffectation == null) ? 0 : dateAffectation.hashCode());
		result = prime * result + idCycle;
		result = prime * result
				+ ((idIdentite == null) ? 0 : idIdentite.hashCode());
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
		AffectationCyclePK other = (AffectationCyclePK) obj;
		if (dateAffectation == null) {
			if (other.dateAffectation != null)
				return false;
		} else if (!dateAffectation.equals(other.dateAffectation))
			return false;
		if (idCycle != other.idCycle)
			return false;
		if (idIdentite == null) {
			if (other.idIdentite != null)
				return false;
		} else if (!idIdentite.equals(other.idIdentite))
			return false;
		return true;
	}

}
