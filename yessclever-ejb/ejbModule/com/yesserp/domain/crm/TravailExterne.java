package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TravailExterne
 *
 */
@Entity
@Table(name="crm_trexrh01")
public class TravailExterne implements Serializable {

	
	private Long id;
	private CommercialExterne commercialExterne;
	private Compte compte;
	private  Type_travail_externe  type_travail_ext ;
	
	private static final long serialVersionUID = 1L;

	public TravailExterne() {
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
	
	@ManyToOne
	public CommercialExterne getCommercialExterne() {
		return commercialExterne;
	}
	public void setCommercialExterne(CommercialExterne commercialExterne) {
		this.commercialExterne = commercialExterne;
	}
	
	@ManyToOne
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	@ManyToOne
	public Type_travail_externe getType_travail_ext() {
		return type_travail_ext;
	}
	public void setType_travail_ext(Type_travail_externe type_travail_ext) {
		this.type_travail_ext = type_travail_ext;
	}
	
   
}
