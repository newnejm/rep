package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Anciennete
 *
 */
@Entity
@Table(name = "GTA_PARAM_ANCIENNETE")

public class Anciennete implements Serializable {

	
	private int ida;
	private Date andebut;
	private Date anfin;
	private int taux;
	private ActiviteAbsence activiteAbsence;
	private static final long serialVersionUID = 1L;

	public Anciennete() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIda() {
		return this.ida;
	}

	public void setIda(int ida) {
		this.ida = ida;
	}   

	public Date getAndebut() {
		return andebut;
	}
	public void setAndebut(Date andebut) {
		this.andebut = andebut;
	}
	public Date getAnfin() {
		return anfin;
	}
	public void setAnfin(Date anfin) {
		this.anfin = anfin;
	}
	public int getTaux() {
		return taux;
	}
	public void setTaux(int taux) {
		this.taux = taux;
	}
	
	@ManyToOne
	public ActiviteAbsence getActiviteAbsence() {
		return activiteAbsence;
	}
	public void setActiviteAbsence(ActiviteAbsence activiteAbsence) {
		this.activiteAbsence = activiteAbsence;
	}
   
}
