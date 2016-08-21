package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RefAbscenceDescJourneeTypePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8225708796875897207L;
	
	private Integer idDescJourneeType;
	private Integer idRefAbscence;

	public Integer getIdDescJourneeType() {
		return idDescJourneeType;
	}

	public Integer getIdRefAbscence() {
		return idRefAbscence;
	}

	public void setIdDescJourneeType(Integer idDescJourneeType) {
		this.idDescJourneeType = idDescJourneeType;
	}

	public void setIdRefAbscence(Integer idRefAbscence) {
		this.idRefAbscence = idRefAbscence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idDescJourneeType == null) ? 0 : idDescJourneeType
						.hashCode());
		result = prime * result
				+ ((idRefAbscence == null) ? 0 : idRefAbscence.hashCode());
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
		RefAbscenceDescJourneeTypePK other = (RefAbscenceDescJourneeTypePK) obj;
		if (idDescJourneeType == null) {
			if (other.idDescJourneeType != null)
				return false;
		} else if (!idDescJourneeType.equals(other.idDescJourneeType))
			return false;
		if (idRefAbscence == null) {
			if (other.idRefAbscence != null)
				return false;
		} else if (!idRefAbscence.equals(other.idRefAbscence))
			return false;
		return true;
	}

}
