package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ParametrageTaxe
 *
 */
@Entity
@Table(name="crm_prtxuf01")
public class ParametrageTaxe implements Serializable {

	
	private Long id;
	private int taux;
	private int taxe;
	private double valeur;
	private static final long serialVersionUID = 1L;

	public ParametrageTaxe() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public int getTaux() {
		return this.taux;
	}

	public void setTaux(int taux) {
		this.taux = taux;
	}   
	public int getTaxe() {
		return this.taxe;
	}

	public void setTaxe(int taxe) {
		this.taxe = taxe;
	}   

	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
   
}
