package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: HoraireDeReference
 * 
 */
@Entity
@Table(name = "GTA_HDRP_RH01")
public class HoraireDeReference implements Serializable {

	private long id;
	private Date heuredep;
	private Date heurefin;
	private int tolinf;
	private int tolsup;
	private JourneeType journeeType;
	private static final long serialVersionUID = 1L;

	public HoraireDeReference() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTolinf() {
		return this.tolinf;
	}

	public void setTolinf(int tolinf) {
		this.tolinf = tolinf;
	}

	public int getTolsup() {
		return this.tolsup;
	}

	public void setTolsup(int tolsup) {
		this.tolsup = tolsup;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeuredep() {
		return heuredep;
	}

	public void setHeuredep(Date heuredep) {
		this.heuredep = heuredep;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeurefin() {
		return heurefin;
	}

	public void setHeurefin(Date heurefin) {
		this.heurefin = heurefin;
	}

	@ManyToOne
	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

}
