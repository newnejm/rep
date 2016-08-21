package com.yesserp.domain.gs;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Inventaire_stock
 * 
 */
@Entity
@Table(name = "gs_inventaire_stock")
public class Inventaire_stock implements Serializable {

	private Stock stock;
	private Inventaire inventaire;
	private Inventaire_stock_pk pk;
	private double qte;
	private String rapport;

	private static final long serialVersionUID = 1L;

	public Inventaire_stock() {
		super();
	}

	@ManyToOne
	@JoinColumn(name = "idstock", referencedColumnName = "id", insertable = false, updatable = false)
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@ManyToOne
	@JoinColumn(name = "idinv", referencedColumnName = "id", insertable = false, updatable = false)
	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	@EmbeddedId
	public Inventaire_stock_pk getPk() {
		return pk;
	}

	public void setPk(Inventaire_stock_pk pk) {
		this.pk = pk;
	}

	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

	public String getRapport() {
		return rapport;
	}

	public void setRapport(String rapport) {
		this.rapport = rapport;
	}
}
