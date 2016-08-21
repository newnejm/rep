package com.yesserp.domain.gta;

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

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.SemaineType;

/**
 * Entity implementation class for Entity: PlanningReel
 * 
 */
@Entity
@Table(name = "GTA_PLANREAL_UF01")
public class PlanningReel implements Serializable {

	private long idp;
	private Date date;
	private Date heuredeb;
	private Date heurefin;
	private Identite identite;
	private PlageHoraire plageHoraire;
	private JourneeType journeeType;
	private SemaineType semaineType;
	private static final long serialVersionUID = 1L;

	public PlanningReel() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdp() {
		return this.idp;
	}

	public void setIdp(long idp) {
		this.idp = idp;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeuredeb() {
		return heuredeb;
	}

	public void setHeuredeb(Date heuredeb) {
		this.heuredeb = heuredeb;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeurefin() {
		return heurefin;
	}

	public void setHeurefin(Date heurefin) {
		this.heurefin = heurefin;
	}

	@ManyToOne
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	@ManyToOne
	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	@ManyToOne
	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}
	@ManyToOne
	public SemaineType getSemaineType() {
		return semaineType;
	}

	public void setSemaineType(SemaineType semaineType) {
		this.semaineType = semaineType;
	}

}
