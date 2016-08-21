package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabFactureProduit
 *
 */
@Entity
@Table(name="crm_tfprhf01")
public class TabFactureProduit implements Serializable {

	
	private Long id;
	private int quantite;
	
	private Facture facture;
	private Produit produit;
	
	private static final long serialVersionUID = 1L;

	public TabFactureProduit() {
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
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	

	
	@ManyToOne
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
   
	
}
