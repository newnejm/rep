package com.yesserp.domain.gta;

import java.io.Serializable;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.CycleTravail;

/**
 * Entity implementation class for Entity: AffectationCycle
 *
 */
@Entity
@Table(name="GTA_AffectCycle")
public class AffectationCycle implements Serializable {
	
	private AffectationCyclePK affectationCyclePK;
    private CycleTravail cycleTravailGTA;
    private Identite identite;
	
	private static final long serialVersionUID = 1L;

	public AffectationCycle() {
		super();
	}
	

	@EmbeddedId
	public AffectationCyclePK getAffectationCyclePK() {
		return affectationCyclePK;
	}

	public void setAffectationCyclePK(AffectationCyclePK affectationCyclePK) {
		this.affectationCyclePK = affectationCyclePK;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCycle",referencedColumnName="idct",insertable=false,updatable=false)
	public CycleTravail getCycleTravailGTA() {
		return cycleTravailGTA;
	}


	public void setCycleTravailGTA(CycleTravail cycleTravailGTA) {
		this.cycleTravailGTA = cycleTravailGTA;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idIdentite",referencedColumnName="numedoss",insertable=false,updatable=false)
	public Identite getIdentite() {
		return identite;
	}


	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
   
}
