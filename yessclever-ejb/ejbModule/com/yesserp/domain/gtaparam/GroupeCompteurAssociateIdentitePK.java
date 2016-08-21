package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class GroupeCompteurAssociateIdentitePK implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public GroupeCompteurAssociateIdentitePK() {
		super();
	}
	private Long idIdentite;
	private int idGrpCompteur;
	private Date dateDeffet;
	private Date dateFin;
	
	
	
	public GroupeCompteurAssociateIdentitePK(Long idIdentite,
			int idGrpCompteur, Date dateDeffet, Date dateFin) {
		super();
		this.idIdentite = idIdentite;
		this.idGrpCompteur = idGrpCompteur;
		this.dateDeffet = dateDeffet;
		this.dateFin = dateFin;
	}
	public Long getIdIdentite() {
		return idIdentite;
	}
	public void setIdIdentite(Long idIdentite) {
		this.idIdentite = idIdentite;
	}
	public int getIdGrpCompteur() {
		return idGrpCompteur;
	}
	public void setIdGrpCompteur(int idGrpCompteur) {
		this.idGrpCompteur = idGrpCompteur;
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
		result = prime * result + idGrpCompteur;
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
		GroupeCompteurAssociateIdentitePK other = (GroupeCompteurAssociateIdentitePK) obj;
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
		if (idGrpCompteur != other.idGrpCompteur)
			return false;
		if (idIdentite == null) {
			if (other.idIdentite != null)
				return false;
		} else if (!idIdentite.equals(other.idIdentite))
			return false;
		return true;
	}
	

}
