package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class GroupeImputationAssociatePK implements Serializable {

	/**
	 * 
	 */
	private Long idIdentite;
	private int idGrpImputation;
	private Date dateDeffet;
	private Date dateFin;
	

	private static final long serialVersionUID = 1L;
	public GroupeImputationAssociatePK() {
		super();
	}
	
	
	
	
	
	//getters and setters
	public Long getIdIdentite() {
		return idIdentite;
	}
	public void setIdIdentite(Long idIdentite) {
		this.idIdentite = idIdentite;
	}
	public int getIdGrpImputation() {
		return idGrpImputation;
	}
	public void setIdGrpImputation(int idGrpImputation) {
		this.idGrpImputation = idGrpImputation;
	}
	public Date getDateDeffet() {
		return dateDeffet;
	}
	public void setDateDeffet(Date dateDeffet) {
		this.dateDeffet = dateDeffet;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateDeffet == null) ? 0 : dateDeffet.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + idGrpImputation;
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
		GroupeImputationAssociatePK other = (GroupeImputationAssociatePK) obj;
		if (dateDeffet == null) {
			if (other.dateDeffet != null)
				return false;
		} else if (!dateDeffet.equals(other.dateDeffet))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (idGrpImputation != other.idGrpImputation)
			return false;
		if (idIdentite == null) {
			if (other.idIdentite != null)
				return false;
		} else if (!idIdentite.equals(other.idIdentite))
			return false;
		return true;
	}
	
	

	
	
	
	
}
