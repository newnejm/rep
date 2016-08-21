package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SemaineTypeDescCycleTravailPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1898921948579946405L;

	private Integer index;
	private Integer idSemaineType;
	private Integer idDescCycleTravail;

	public Integer getIdSemaineType() {
		return idSemaineType;
	}

	public Integer getIdDescCycleTravail() {
		return idDescCycleTravail;
	}

	public void setIdSemaineType(Integer idSemaineType) {
		this.idSemaineType = idSemaineType;
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
				+ ((idSemaineType == null) ? 0 : idSemaineType.hashCode());
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
		SemaineTypeDescCycleTravailPK other = (SemaineTypeDescCycleTravailPK) obj;
		if (idDescCycleTravail == null) {
			if (other.idDescCycleTravail != null)
				return false;
		} else if (!idDescCycleTravail.equals(other.idDescCycleTravail))
			return false;
		if (idSemaineType == null) {
			if (other.idSemaineType != null)
				return false;
		} else if (!idSemaineType.equals(other.idSemaineType))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		return true;
	}

}
