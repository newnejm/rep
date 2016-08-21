package com.yesserp.domain.gf;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class FourFraisC implements Serializable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result
				+ ((idFournisseur == null) ? 0 : idFournisseur.hashCode());
		result = prime * result + ((idFrais == null) ? 0 : idFrais.hashCode());
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
		FourFraisC other = (FourFraisC) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (idFournisseur == null) {
			if (other.idFournisseur != null)
				return false;
		} else if (!idFournisseur.equals(other.idFournisseur))
			return false;
		if (idFrais == null) {
			if (other.idFrais != null)
				return false;
		} else if (!idFrais.equals(other.idFrais))
			return false;
		return true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idFournisseur;
	private Long idFrais;
	private Date dateDebut;
	private Date dateFin;

	public Long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public Long getIdFrais() {
		return idFrais;
	}

	public void setIdFrais(Long idFrais) {
		this.idFrais = idFrais;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
