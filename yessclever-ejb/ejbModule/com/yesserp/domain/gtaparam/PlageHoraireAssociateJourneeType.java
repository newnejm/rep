package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: PlageHoraireAssociateJourneeType
 * 
 */
@Entity
public class PlageHoraireAssociateJourneeType implements Serializable {
	private PlageHAssociateJourneeTPK hAssociateJourneeTPK;
	private PlageHoraire plageHoraire;
	private JourneeType journeeType;
	private int heureFin;
	private static final long serialVersionUID = 1L;

	public PlageHoraireAssociateJourneeType() {
		super();
	}

	@EmbeddedId
	public PlageHAssociateJourneeTPK gethAssociateJourneeTPK() {
		return hAssociateJourneeTPK;
	}

	public void sethAssociateJourneeTPK(
			PlageHAssociateJourneeTPK hAssociateJourneeTPK) {
		this.hAssociateJourneeTPK = hAssociateJourneeTPK;
	}

	@ManyToOne
	@JoinColumn(name = "idPlageHorraire", referencedColumnName = "idph", insertable = false, updatable = false)
	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

	@ManyToOne
	@JoinColumn(name = "idJourneeType", referencedColumnName = "idjt", insertable = false, updatable = false)
	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	public int getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}

}
