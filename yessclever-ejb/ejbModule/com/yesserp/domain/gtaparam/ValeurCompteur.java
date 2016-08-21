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

@Entity
@Table(name = "GTA_VALCMPT")
public class ValeurCompteur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int valeurNumerique;
	private long valeurHoraire;
	private Date dateCalc;
	private Compteur compteur;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateCalc() {
		return dateCalc;
	}

	public void setDateCalc(Date dateCalc) {
		this.dateCalc = dateCalc;
	}

	@ManyToOne
	public Compteur getCompteur() {
		return compteur;
	}

	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}

	public int getValeurNumerique() {
		return valeurNumerique;
	}

	public void setValeurNumerique(int valeurNumerique) {
		this.valeurNumerique = valeurNumerique;
	}

	public long getValeurHoraire() {
		return valeurHoraire;
	}

	public void setValeurHoraire(long valeurHoraire) {
		this.valeurHoraire = valeurHoraire;
	}

}
