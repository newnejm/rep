package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CycleAssociateJourneeTypeEmbeddebale implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idCycleTravail;
	private int idJourneeType;
	private int ordreJournee;
	
	public CycleAssociateJourneeTypeEmbeddebale(){
		
	}
	

	public int getIdCycleTravail() {
		return idCycleTravail;
	}

	public void setIdCycleTravail(int idCycleTravail) {
		this.idCycleTravail = idCycleTravail;
	}

	public int getIdJourneeType() {
		return idJourneeType;
	}

	public void setIdJourneeType(int idJourneeType) {
		this.idJourneeType = idJourneeType;
	}

	public int getOrdreJournee() {
		return ordreJournee;
	}

	public void setOrdreJournee(int ordreJournee) {
		this.ordreJournee = ordreJournee;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCycleTravail;
		result = prime * result + idJourneeType;
		result = prime * result + ordreJournee;
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
		CycleAssociateJourneeTypeEmbeddebale other = (CycleAssociateJourneeTypeEmbeddebale) obj;
		if (idCycleTravail != other.idCycleTravail)
			return false;
		if (idJourneeType != other.idJourneeType)
			return false;
		if (ordreJournee != other.ordreJournee)
			return false;
		return true;
	}
	

}
