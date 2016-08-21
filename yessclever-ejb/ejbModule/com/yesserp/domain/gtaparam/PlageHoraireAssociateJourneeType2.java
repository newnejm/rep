package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class PlageHoraireAssociateJourneeType2  implements Serializable{
	
	private PlageHAssociateJourneeTPK2 hAssociateJourneeTPK2 ;
	private PlageHoraire2 plageHoraire2 ; 
	private JourneeType journeeType ;
	private JourneeType2 journeeType2 ;
	private int heurefin ;
	private static final long serialVersionUID =1L ;
	
	public PlageHoraireAssociateJourneeType2() {
		super();
	}

	
	@EmbeddedId
	public PlageHAssociateJourneeTPK2 gethAssociateJourneeTPK2() {
		return hAssociateJourneeTPK2;
	}

	@ManyToOne
	@JoinColumn(name="idph2",referencedColumnName = "idph2", insertable =false , updatable =false)
	public PlageHoraire2 getPlageHoraire2() {
		return plageHoraire2;
	}

	
	
	public JourneeType getJourneeType() {
		return journeeType;
	}

	@ManyToOne
	@JoinColumn(name = "JourneeType2", referencedColumnName = "idjt2", insertable = false, updatable = false)
	public JourneeType2 getJourneeType2() {
		return journeeType2;
	}


	public void setJourneeType2(JourneeType2 journeeType2) {
		this.journeeType2 = journeeType2;
	}


	public int getHeurefin() {
		return heurefin;
	}

	public void sethAssociateJourneeTPK2(
			PlageHAssociateJourneeTPK2 hAssociateJourneeTPK2) {
		this.hAssociateJourneeTPK2 = hAssociateJourneeTPK2;
	}

	public void setPlageHoraire2(PlageHoraire2 plageHoraire2) {
		this.plageHoraire2 = plageHoraire2;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	public void setHeurefin(int heurefin) {
		this.heurefin = heurefin;
	}
	
	
	
	

}
