package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ParamFacture
 *
 */
@Entity
@Table(name="crm_prmfrh01")
public class ParamFacture implements Serializable {

	
	private Long id;
	private String nom;
	private String formule;
	private double valeur;
	private static final long serialVersionUID = 1L;

	public ParamFacture() {
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
	public String getFormule() {
		return this.formule;
	}

	public void setFormule(String formule) {
		this.formule = formule;
	}
	
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}   

   
}
