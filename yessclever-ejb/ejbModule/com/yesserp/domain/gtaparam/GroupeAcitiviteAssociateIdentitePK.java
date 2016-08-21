package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class GroupeAcitiviteAssociateIdentitePK implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public GroupeAcitiviteAssociateIdentitePK() {
		super();
	}
	private Long idIdentite;
	private int idGrpActivite;
	private Date dateDeffet;
	private Date dateFin;
	
	
	

	public Long getIdIdentite() {
		return idIdentite;
	}
	public void setIdIdentite(Long idIdentite) {
		this.idIdentite = idIdentite;
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
	public int getIdGrpActivite() {
		return idGrpActivite;
	}
	public void setIdGrpActivite(int idGrpActivite) {
		this.idGrpActivite = idGrpActivite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateDeffet == null) ? 0 : dateDeffet.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + idGrpActivite;
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
		GroupeAcitiviteAssociateIdentitePK other = (GroupeAcitiviteAssociateIdentitePK) obj;
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
		if (idGrpActivite != other.idGrpActivite)
			return false;
		if (idIdentite == null) {
			if (other.idIdentite != null)
				return false;
		} else if (!idIdentite.equals(other.idIdentite))
			return false;
		return true;
	}
	
	
	
}
