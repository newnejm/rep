package com.yesserp.domain.gs;

import java.io.Serializable;

import javax.persistence.*;

import com.yesserp.type.gs.*;

import sun.nio.cs.Surrogate.Generator;

/**
 * Entity implementation class for Entity: Produit
 * 
 */
@Entity
@Table(name = "gs_prod")
public class Prod implements Serializable {

	private int id;
	private String code;
	private TypeProd type;
	private double c_achat;
	private double c_vente;
	private double TVA;
	private boolean peris;
	private Umesure umes;

	private Categorie cat;
	private Sous_Categorie s_cat;
	private Stock stock;

	private static final long serialVersionUID = 1L;

	public Prod() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(unique = true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TypeProd getType() {
		return type;
	}

	public void setType(TypeProd type) {
		this.type = type;
	}

	public double getC_achat() {
		return c_achat;
	}

	public void setC_achat(double c_achat) {
		this.c_achat = c_achat;
	}

	public double getC_vente() {
		return c_vente;
	}

	public void setC_vente(double c_vente) {
		this.c_vente = c_vente;
	}

	public double getTVA() {
		return TVA;
	}

	public void setTVA(double tVA) {
		TVA = tVA;
	}

	public boolean isPeris() {
		return peris;
	}

	public void setPeris(boolean peris) {
		this.peris = peris;
	}

	@ManyToOne
	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	@ManyToOne
	public Sous_Categorie getS_cat() {
		return s_cat;
	}

	public void setS_cat(Sous_Categorie s_cat) {
		this.s_cat = s_cat;
	}

	@OneToOne
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@ManyToOne
	public Umesure getUmes() {
		return umes;
	}

	public void setUmes(Umesure umes) {
		this.umes = umes;
	}
}
