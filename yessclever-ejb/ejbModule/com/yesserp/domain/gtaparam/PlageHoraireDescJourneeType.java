package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PlageHoraireDescJourneeType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1150380324208001776L;

	private PlageHoraireDescJourneeTypePK phdescJT;
	private DescJourneeType descJourneeType;
	private PlageHoraire plageHoraire;
	private Date heure;

	@EmbeddedId
	public PlageHoraireDescJourneeTypePK getPhdescJT() {
		return phdescJT;
	}

	@ManyToOne
	@JoinColumn(name = "idDescJourneeType", unique = false, referencedColumnName = "id", insertable = false, updatable = false)
	public DescJourneeType getDescJourneeType() {
		return descJourneeType;
	}

	@ManyToOne
	@JoinColumn(name = "idPlageHoraire", referencedColumnName = "idph", insertable = false, updatable = false)
	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeure() {
		return heure;
	}

	public void setPhdescJT(PlageHoraireDescJourneeTypePK phdescJT) {
		this.phdescJT = phdescJT;
	}

	public void setDescJourneeType(DescJourneeType descJourneeType) {
		this.descJourneeType = descJourneeType;
	}

	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

	public void setHeure(Date heure) {
		this.heure = heure;
	}

}
