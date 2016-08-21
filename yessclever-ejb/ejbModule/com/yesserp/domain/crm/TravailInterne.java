package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TravailInterne
 *
 */
@Entity
@Table(name="crm_trinrh01")
public class TravailInterne implements Serializable {

	
	private Long id;
	private CommercialInterne CommercialInterne;
	private Compte compte;
	private String date;
	private String heure;
	
	
	
	
	
	private static final long serialVersionUID = 1L;

	public TravailInterne() {
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
	public CommercialInterne getCommercialInterne() {
		return CommercialInterne;
	}
	public void setCommercialInterne(CommercialInterne CommercialInterne) {
		this.CommercialInterne = CommercialInterne;
	}
	
	@ManyToOne
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	
   
}
