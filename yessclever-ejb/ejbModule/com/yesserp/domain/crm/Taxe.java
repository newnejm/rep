package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Taxe
 *
 */
@Entity
@Table(name="crm_taxeuf01")
public class Taxe implements Serializable {

	
	private Long id;
	private int nom;
	private TypeTaxe typeTaxe;
	private List<Produit> produits;
	private List<Service> services;

	
	
	private static final long serialVersionUID = 1L;

	public Taxe() {
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
	public int getNom() {
		return this.nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}
	
	

	@ManyToOne
	public TypeTaxe getTypeTaxe() {
		return typeTaxe;
	}
	public void setTypeTaxe(TypeTaxe typeTaxe) {
		this.typeTaxe = typeTaxe;
	}
	
	
	@OneToMany(mappedBy="taxe",cascade=CascadeType.ALL)
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	@OneToMany(mappedBy="taxe",cascade=CascadeType.ALL)
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nom;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taxe other = (Taxe) obj;
		if (nom != other.nom)
			return false;
		return true;
	}
	

	
	
   
}
