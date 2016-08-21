package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class AffectationCodeCalPK implements Serializable {
	
	

	private Long idIdentite;
	private int idCodeCal;
	private Date dateAffectation;
	private String code ;
	
	public AffectationCodeCalPK() {
		super();
	}
	
	
	
	public Long getIdIdentite() {
		return idIdentite;
	}
	public void setIdIdentite(Long idIdentite) {
		this.idIdentite = idIdentite;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	public int getIdCodeCal() {
		return idCodeCal;
	}
	public void setIdCodeCal(int idCodeCal) {
		this.idCodeCal = idCodeCal;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((dateAffectation == null) ? 0 : dateAffectation.hashCode());
		result = prime * result + idCodeCal;
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
		AffectationCodeCalPK other = (AffectationCodeCalPK) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dateAffectation == null) {
			if (other.dateAffectation != null)
				return false;
		} else if (!dateAffectation.equals(other.dateAffectation))
			return false;
		if (idCodeCal != other.idCodeCal)
			return false;
		if (idIdentite == null) {
			if (other.idIdentite != null)
				return false;
		} else if (!idIdentite.equals(other.idIdentite))
			return false;
		return true;
	}


	
	
	
	

}
