package com.yesserp.domain.gs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.jboss.resteasy.spi.touri.MappedBy;

/**
 * Entity implementation class for Entity: Lot
 * 
 */
@Entity
@Table(name = "gs_lot")
public class Lot implements Serializable {

	private int id;
	private String code;
	private double qte;
	private double cout_unitaire;
	private double prix_vente;
	private Date d_enreg;
	private Date d_limite;
	private double qteconso;
	private double qterebu;
	private String descrebu;

	private Stock stock;
	private Magasin magasin;

	private List<Consomation_lot> lc;

	private static final long serialVersionUID = 1L;

	public Lot() {
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

	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

	public Date getD_enreg() {
		return d_enreg;
	}

	public void setD_enreg(Date d_enreg) {
		this.d_enreg = d_enreg;
	}

	public Date getD_limite() {
		return d_limite;
	}

	public void setD_limite(Date d_limite) {
		this.d_limite = d_limite;
	}

	@ManyToOne
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@ManyToOne
	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getQterebu() {
		return qterebu;
	}

	public void setQterebu(double qterebu) {
		this.qterebu = qterebu;
	}

	public String getDescrebu() {
		return descrebu;
	}

	public void setDescrebu(String descrebu) {
		this.descrebu = descrebu;
	}

	public double getCout_unitaire() {
		return cout_unitaire;
	}

	public void setCout_unitaire(double cout_unitaire) {
		this.cout_unitaire = cout_unitaire;
	}

	public double getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(double prix_vente) {
		this.prix_vente = prix_vente;
	}

	public double getQteconso() {
		return qteconso;
	}

	public void setQteconso(double qteconso) {
		this.qteconso = qteconso;
	}

	@OneToMany(mappedBy = "lot",cascade = CascadeType.ALL)
	public List<Consomation_lot> getLc() {
		return lc;
	}

	public void setLc(List<Consomation_lot> lc) {
		this.lc = lc;
	}

}
