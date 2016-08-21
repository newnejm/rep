package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeCommercialExterne
 *
 */
@Entity
@Table(name="crm_tycerh01")
public class TypeCommercialExterne implements Serializable {

	
	private Long id;
	private String nom ;
	private List<CommercialExterne> commercialExternes;
	
	private static final long serialVersionUID = 1L;

	public TypeCommercialExterne() {
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
	
	
	@OneToMany(mappedBy="typeCommercialExterne",cascade=CascadeType.ALL)
	public List<CommercialExterne> getCommercialExternes() {
		return commercialExternes;
	}
	public void setCommercialExternes(List<CommercialExterne> commercialExternes) {
		this.commercialExternes = commercialExternes;
	}
	
	
	
   
}
