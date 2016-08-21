package com.yesserp.domain.gta;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.PlageHoraire;

/**
 * Entity implementation class for Entity: ExceptionPlageHoraire
 *
 */
@Entity
@Table(name="GTA_excpla")
public class ExceptionPlageHoraire implements Serializable {

	
	private int id;
	private Date dateChangement;
	private String plageAvant;
	private Date dateJourModifie;
	private PlageHoraire plageHoraire;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public ExceptionPlageHoraire() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getDateChangement() {
		return this.dateChangement;
	}

	public void setDateChangement(Date dateChangement) {
		this.dateChangement = dateChangement;
	}   
	public String getPlageAvant() {
		return this.plageAvant;
	}

	public void setPlageAvant(String plageAvant) {
		this.plageAvant = plageAvant;
	}   
	public Date getDateJourModifie() {
		return this.dateJourModifie;
	}

	public void setDateJourModifie(Date dateJourModifie) {
		this.dateJourModifie = dateJourModifie;
	}
	@ManyToOne
	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}
	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	@ManyToOne
	public Identite getIdentite() {
		return identite;
	}
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
   
}
