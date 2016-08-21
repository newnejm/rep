package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class SemaineTypeDescCycleTravail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3875842018445635232L;

	private SemaineTypeDescCycleTravailPK semaineTypeDescCycleTravailPK;
	private Integer index;
	private SemaineType semaineType;
	private DescCycleTravail descCycleTravail;	

	@EmbeddedId
	public SemaineTypeDescCycleTravailPK getSemaineTypeDescCycleTravailPK() {
		return semaineTypeDescCycleTravailPK;
	}

	@ManyToOne
	@JoinColumn(name = "idSemaineType", referencedColumnName = "idst", insertable = false, updatable = false, unique = false)
	public SemaineType getSemaineType() {
		return semaineType;
	}

	@ManyToOne
	@JoinColumn(name = "idDescCycleTravail", unique = false, referencedColumnName = "idDescCT", insertable = false, updatable = false)
	public DescCycleTravail getDescCycleTravail() {
		return descCycleTravail;
	}

	public void setSemaineTypeDescCycleTravailPK(
			SemaineTypeDescCycleTravailPK semaineTypeDescCycleTravailPK) {
		this.semaineTypeDescCycleTravailPK = semaineTypeDescCycleTravailPK;
	}

	public void setSemaineType(SemaineType semaineType) {
		this.semaineType = semaineType;
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
