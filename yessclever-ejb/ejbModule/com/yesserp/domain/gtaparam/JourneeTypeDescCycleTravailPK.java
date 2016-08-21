package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class JourneeTypeDescCycleTravailPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer index;
	private Integer idJourneeType;
	private Integer idDescCycleTravail;

	public Integer getIdJourneeType() {
		return idJourneeType;
	}

	public Integer getIdDescCycleTravail() {
		return idDescCycleTravail;
	}

	public void setIdJourneeType(Integer idJourneeType) {
		this.idJourneeType = idJourneeType;
	}

	public void setIdDescCycleTravail(Integer idDescCycleTravail) {
		this.idDescCycleTravail = idDescCycleTravail;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idDescCycleTravail == null) ? 0 : idDescCycleTravail
						.hashCode());
		result = prime * result
				+ ((idJourneeType == null) ? 0 : idJourneeType.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
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
		JourneeTypeDescCycleTravailPK other = (JourneeTypeDescCycleTravailPK) obj;
		if (idDescCycleTravail == null) {
			if (other.idDescCycleTravail != null)
				return false;
		} else if (!idDescCycleTravail.equals(other.idDescCycleTravail))
			return false;
		if (idJourneeType == null) {
			if (other.idJourneeType != null)
				return false;
		} else if (!idJourneeType.equals(other.idJourneeType))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		return true;
	}

}
