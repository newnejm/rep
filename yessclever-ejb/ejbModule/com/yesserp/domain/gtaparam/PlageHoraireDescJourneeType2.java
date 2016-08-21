package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class PlageHoraireDescJourneeType2 implements Serializable {
	
	private static final long serialVersionUID = 1L ;
	
	private PlageHoraireDescJourneeType2PK phdescJT2 ;
	private DescJourneeType2 descJourneeType2 ;
	private PlageHoraire2 plageHoraire2 ;
	private Date heure ;
	
	@EmbeddedId
	public PlageHoraireDescJourneeType2PK getPhdescJT2() {
		return phdescJT2;
	}
	
	@ManyToOne
	@JoinColumn(name="idDescJourneeType", unique = false , referencedColumnName ="id" , insertable = false, updatable = false )
	public DescJourneeType2 getDescJourneeType2() {
		return descJourneeType2;
	}
	
	
	@ManyToOne
	@JoinColumn(name="idPlageHoraire", referencedColumnName ="idph2" ,insertable = false , updatable =false   )
	public PlageHoraire2 getPlageHoraire2() {
		return plageHoraire2;
	}
	
	@Temporal(TemporalType.TIME)
	public Date getHeure() {
		return heure;
	}
	public void setPhdescJT2(PlageHoraireDescJourneeType2PK phdescJT2) {
		this.phdescJT2 = phdescJT2;
	}
	public void setDescJourneeType2(DescJourneeType2 descJourneeType2) {
		this.descJourneeType2 = descJourneeType2;
	}
	public void setPlageHoraire2(PlageHoraire2 plageHoraire2) {
		this.plageHoraire2 = plageHoraire2;
	}
	public void setHeure(Date heure) {
		this.heure = heure;
	}
	
	
	
	

}
