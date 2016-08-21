package com.yesserp.domain.gta;

import java.util.Date;

public class CalculCompteur {
	
	private int valeurNumerique;
	private Date valeurHoraire;
	private Date dateCalc;
	
	
	
	
	public CalculCompteur( Date dateCalc,int valeurNumerique, Date valeurHoraire) {
		super();
		this.valeurNumerique = valeurNumerique;
		this.valeurHoraire = valeurHoraire;
		this.dateCalc = dateCalc;
	}
	public int getValeurNumerique() {
		return valeurNumerique;
	}
	public void setValeurNumerique(int valeurNumerique) {
		this.valeurNumerique = valeurNumerique;
	}
	public Date getValeurHoraire() {
		return valeurHoraire;
	}
	public void setValeurHoraire(Date valeurHoraire) {
		this.valeurHoraire = valeurHoraire;
	}
	public Date getDateCalc() {
		return dateCalc;
	}
	public void setDateCalc(Date dateCalc) {
		this.dateCalc = dateCalc;
	}
	

}
