package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class SemaineJourneesPK implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSemaine;
	private int idJournee;
	private int idCodejour;
	
	
	
	
	
	public SemaineJourneesPK() {
		super();
	}

	public int getIdSemaine() {
		return idSemaine;
	}
	
	public void setIdSemaine(int idSemaine) {
		this.idSemaine = idSemaine;
	}
	
	public int getIdJournee() {
		return idJournee;
	}
	public void setIdJournee(int idJournee) {
		this.idJournee = idJournee;
	}
	public int getIdCodejour() {
		return idCodejour;
	}

	public void setIdCodejour(int idCodejour) {
		this.idCodejour = idCodejour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCodejour;
		result = prime * result + idJournee;
		result = prime * result + idSemaine;
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
		SemaineJourneesPK other = (SemaineJourneesPK) obj;
		if (idCodejour != other.idCodejour)
			return false;
		if (idJournee != other.idJournee)
			return false;
		if (idSemaine != other.idSemaine)
			return false;
		return true;
	}
	
}
