package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeTaxe
 *
 */
@Entity
@Table(name="crm_tytxuf01")
public class TypeTaxe implements Serializable {

	
	private Long id;
	private String nom;
	private List<Taux> tauxs;
	private List<Taxe> taxes;
	
	private static final long serialVersionUID = 1L;

	public TypeTaxe() {
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


	
	@OneToMany(mappedBy="typeTaxe",cascade=CascadeType.ALL)
	public List<Taux> getTauxs() {
		return tauxs;
	}
	public void setTauxs(List<Taux> tauxs) {
		this.tauxs = tauxs;
		
	}
	
	
	@OneToMany(mappedBy="typeTaxe",cascade=CascadeType.ALL)
	public List<Taxe> getTaxes() {
		return taxes;
	}
	public void setTaxes(List<Taxe> taxes) {
		this.taxes = taxes;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
   
}
