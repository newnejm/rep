package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeCommercialInterne
 *
 */
@Entity
@Table(name="crm_tycirh01")
public class TypeCommercialInterne implements Serializable {

	
	private Long id;
	private String nom ;
	private List<CommercialInterne> identiteCommercials;
	
	
	private static final long serialVersionUID = 1L;

	public TypeCommercialInterne() {
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	@OneToMany(mappedBy="typeCommercialInterne")
	public List<CommercialInterne> getIdentiteCommercials() {
		return identiteCommercials;
	}
	public void setIdentiteCommercials(List<CommercialInterne> identiteCommercials) {
		this.identiteCommercials = identiteCommercials;
	}
   
}
