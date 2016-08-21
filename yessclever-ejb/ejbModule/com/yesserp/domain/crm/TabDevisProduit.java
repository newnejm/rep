package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabDevisProduit
 *
 */
@Entity
@Table(name = "crm_tdprrh01")
public class TabDevisProduit implements Serializable {

	
	private Long id;
	private int quantite;
	
	private Produit produit;
	private Devis devis;
	
	private static final long serialVersionUID = 1L;

	public TabDevisProduit() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	@ManyToOne
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	@ManyToOne
	public Devis getDevis() {
		return devis;
	}
	public void setDevis(Devis devis) {
		this.devis = devis;
	}
   
}
