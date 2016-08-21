package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Type_travail_externe
 *
 */
@Entity
@Table(name="crm_tytrexrh01")
public class Type_travail_externe implements Serializable {

	
	private int id;
	private String nom;
	private List<TravailExterne> travails_ext;
	private static final long serialVersionUID = 1L;

	public Type_travail_externe() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@OneToMany(mappedBy="type_travail_ext" , cascade=CascadeType.ALL)
	public List<TravailExterne> getTravails_ext() {
		return travails_ext;
	}
	public void setTravails_ext(List<TravailExterne> travails_ext) {
		this.travails_ext = travails_ext;
	}
   
}
