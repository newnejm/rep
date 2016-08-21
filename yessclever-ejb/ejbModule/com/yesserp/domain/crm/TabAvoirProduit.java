package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabAvoirProduit
 *
 */
@Entity
@Table(name="crm_tapruh01")
public class TabAvoirProduit implements Serializable {

	
	private Long id;
	private int quantite;
	
	private Avoir avoir;
	private Produit produit;
	
	
	private static final long serialVersionUID = 1L;

	public TabAvoirProduit() {
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
	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	@ManyToOne
	public Avoir getAvoir() {
		return avoir;
	}
	public void setAvoir(Avoir avoir) {
		this.avoir = avoir;
	}
	
	@ManyToOne
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
   
}
