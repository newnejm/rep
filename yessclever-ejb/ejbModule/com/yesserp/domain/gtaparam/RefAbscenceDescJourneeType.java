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
public class RefAbscenceDescJourneeType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1150380324208001776L;

	private RefAbscenceDescJourneeTypePK phdescJT;
	private DescJourneeType descJourneeType;
	private RefAbscence refAbscence;
	private Date heure;

	@EmbeddedId
	public RefAbscenceDescJourneeTypePK getPhdescJT() {
		return phdescJT;
	}

	@ManyToOne
	@JoinColumn(name = "idDescJourneeType", unique = false, referencedColumnName = "id", insertable = false, updatable = false)
	public DescJourneeType getDescJourneeType() {
		return descJourneeType;
	}

	@ManyToOne
	@JoinColumn(name = "idRefAbscence", referencedColumnName = "idap", insertable = false, updatable = false)
	public RefAbscence getrefAbscence() {
		return refAbscence;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeure() {
		return heure;
	}

	public void setPhdescJT(RefAbscenceDescJourneeTypePK phdescJT) {
		this.phdescJT = phdescJT;
	}

	public void setDescJourneeType(DescJourneeType descJourneeType) {
		this.descJourneeType = descJourneeType;
	}

	public void setrefAbscence(RefAbscence refAbscence) {
		this.refAbscence = refAbscence;
	}

	public void setHeure(Date heure) {
		this.heure = heure;
	}

}
