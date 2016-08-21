package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class PlageHoraireDescJourneeType2PK  implements Serializable     {
	
	private static final long  serialVersionUID = 1L ;
	
	private Integer idDescJourneeType ;
	private Integer idPlageHoraire ;
	
	public Integer getIdDescJourneeType() {
		return idDescJourneeType;
	}
	public Integer getIdPlageHoraire() {
		return idPlageHoraire;
	}
	public void setIdDescJourneeType(Integer idDescJourneeType) {
		this.idDescJourneeType = idDescJourneeType;
	}
	public void setIdPlageHoraire(Integer idPlageHoraire) {
		this.idPlageHoraire = idPlageHoraire;
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
				+ ((idPlageHoraire == null) ? 0 : idPlageHoraire.hashCode());
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
		PlageHoraireDescJourneeType2PK other = (PlageHoraireDescJourneeType2PK) obj;
		if (idDescJourneeType == null) {
			if (other.idDescJourneeType != null)
				return false;
		} else if (!idDescJourneeType.equals(other.idDescJourneeType))
			return false;
		if (idPlageHoraire == null) {
			if (other.idPlageHoraire != null)
				return false;
		} else if (!idPlageHoraire.equals(other.idPlageHoraire))
			return false;
		return true;
	}
	
	

}
