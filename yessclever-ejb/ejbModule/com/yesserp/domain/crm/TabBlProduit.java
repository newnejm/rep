package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabBlFactureProduit
 *
 */
@Entity
@Table(name="crm_tlpruf01")
public class TabBlProduit implements Serializable {

	
	private Long id;
	private int quantite;
	
	private Bl bl;
	private Produit produit;
	
	private static final long serialVersionUID = 1L;

	public TabBlProduit() {
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
	public Bl getBl() {
		return bl;
	}
	public void setBl(Bl bl) {
		this.bl = bl;
	}
	
	@ManyToOne
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
   
}
