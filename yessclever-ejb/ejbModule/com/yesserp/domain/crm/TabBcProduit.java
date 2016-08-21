package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabBcProduit
 *
 */
@Entity
@Table(name="crm_tbprrh01")
public class TabBcProduit implements Serializable {

	
	private Long id;
	private int quantite;
	
	private Bc bc;
	private Produit produit;
	
	private static final long serialVersionUID = 1L;

	public TabBcProduit() {
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
	public Bc getBc() {
		return bc;
	}
	public void setBc(Bc bc) {
		this.bc = bc;
	}
	
	@ManyToOne
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
   
}
