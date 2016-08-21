package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class AffectationClassEpmPK implements Serializable {
	
	

	private Long idIdentite;
	private int idClassEmp;
	private Date dateAffectation;
	
	public AffectationClassEpmPK() {
		super();
	}
	
	
	public int getIdClassEmp() {
		return idClassEmp;
	}
	public void setIdClassEmp(int idClassEmp) {
		this.idClassEmp = idClassEmp;
	}
	public Long getIdIdentite() {
		return idIdentite;
	}
	public void setIdIdentite(Long idIdentite) {
		this.idIdentite = idIdentite;
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
		result = prime * result + idClassEmp;
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
		AffectationClassEpmPK other = (AffectationClassEpmPK) obj;
		if (dateAffectation == null) {
			if (other.dateAffectation != null)
				return false;
		} else if (!dateAffectation.equals(other.dateAffectation))
			return false;
		if (idClassEmp != other.idClassEmp)
			return false;
		if (idIdentite == null) {
			if (other.idIdentite != null)
				return false;
		} else if (!idIdentite.equals(other.idIdentite))
			return false;
		return true;
	}


	

}
