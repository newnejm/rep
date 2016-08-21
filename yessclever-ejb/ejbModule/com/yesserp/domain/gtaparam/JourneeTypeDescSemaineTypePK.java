package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class JourneeTypeDescSemaineTypePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1898921948579946405L;

	private Integer idJourneeType;
	private Integer idDescSemaineType;
	private int idCodeJour;

	public int getIdCodeJour() {
		return idCodeJour;
	}

	public void setIdCodeJour(int idCodeJour) {
		this.idCodeJour = idCodeJour;
	}

	public Integer getIdJourneeType() {
		return idJourneeType;
	}

	public Integer getIdDescSemaineType() {
		return idDescSemaineType;
	}

	public void setIdJourneeType(Integer idJourneeType) {
		this.idJourneeType = idJourneeType;
	}

	public void setIdDescSemaineType(Integer idDescSemaineType) {
		this.idDescSemaineType = idDescSemaineType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCodeJour;
		result = prime
				* result
				+ ((idDescSemaineType == null) ? 0 : idDescSemaineType
						.hashCode());
		result = prime * result
				+ ((idJourneeType == null) ? 0 : idJourneeType.hashCode());
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
		JourneeTypeDescSemaineTypePK other = (JourneeTypeDescSemaineTypePK) obj;
		if (idCodeJour != other.idCodeJour)
			return false;
		if (idDescSemaineType == null) {
			if (other.idDescSemaineType != null)
				return false;
		} else if (!idDescSemaineType.equals(other.idDescSemaineType))
			return false;
		if (idJourneeType == null) {
			if (other.idJourneeType != null)
				return false;
		} else if (!idJourneeType.equals(other.idJourneeType))
			return false;
		return true;
	}

	

	
	

}
