package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class JourneeTypeDescCycleTravail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JourneeTypeDescCycleTravailPK journeeTypeDescCycleTravailPK;
	private Integer index;
	private JourneeType journeeType;
	private DescCycleTravail descCycleTravail;
	

	@EmbeddedId
	public JourneeTypeDescCycleTravailPK getJourneeTypeDescCycleTravailPK() {
		return journeeTypeDescCycleTravailPK;
	}

	@ManyToOne
	@JoinColumn(name = "idJourneeType", referencedColumnName = "idjt", insertable = false, updatable = false)
	public JourneeType getJourneeType() {
		return journeeType;
	}

	@ManyToOne
	@JoinColumn(name = "idDescCycleTravail", unique = false, referencedColumnName = "idDescCT", insertable = false, updatable = false)
	public DescCycleTravail getDescCycleTravail() {
		return descCycleTravail;
	}

	public void setJourneeTypeDescCycleTravailPK(
			JourneeTypeDescCycleTravailPK journeeTypeDescCycleTravailPK) {
		this.journeeTypeDescCycleTravailPK = journeeTypeDescCycleTravailPK;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	public void setDescCycleTravail(DescCycleTravail descCycleTravail) {
		this.descCycleTravail = descCycleTravail;
	}

	@Column(insertable = false, updatable = false)
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
