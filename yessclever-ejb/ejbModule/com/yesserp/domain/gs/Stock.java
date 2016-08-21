package com.yesserp.domain.gs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.yesserp.type.gs.TypeEval;
import com.yesserp.type.gs.TypeLivr;
import com.yesserp.type.gs.TypeStock;

/**
 * Entity implementation class for Entity: stock
 * 
 */
@Entity
@Table(name = "gs_stock")
public class Stock implements Serializable {

	private int id;
	private String code;
	private TypeStock type;
	private double qte;
	private double n_sec;
	private TypeLivr typeLiv;
	private TypeEval typeeval;
	private double valeur;

	private Prod prod;
	private List<Lot> lot;
	private STOK stok;

	private List<Inventaire_stock> linvstock = new ArrayList<Inventaire_stock>();

	private static final long serialVersionUID = 1L;

	public Stock() {
		super();
	}

	public Stock(String code) {
		this.code = code;
		this.typeLiv = TypeLivr.standar;
	}

	@Column(unique = true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeStock getType() {
		return type;
	}

	public void setType(TypeStock type) {
		this.type = type;
	}

	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

	public double getN_sec() {
		return n_sec;
	}

	public void setN_sec(double n_sec) {
		this.n_sec = n_sec;
	}

	public TypeLivr getTypeLiv() {
		return typeLiv;
	}

	public void setTypeLiv(TypeLivr typeLiv) {
		this.typeLiv = typeLiv;
	}

	@OneToOne(mappedBy = "stock")
	public Prod getProd() {
		return prod;
	}

	public void setProd(Prod prod) {
		this.prod = prod;
	}

	@OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
	public List<Lot> getLot() {
		return lot;
	}

	public void setLot(List<Lot> lot) {
		this.lot = lot;
	}

	@ManyToOne
	public STOK getStok() {
		return stok;
	}

	public void setStok(STOK stok) {
		this.stok = stok;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public TypeEval getTypeeval() {
		return typeeval;
	}

	public void setTypeeval(TypeEval typeeval) {
		this.typeeval = typeeval;
	}

	@OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
	public List<Inventaire_stock> getLinvstock() {
		return linvstock;
	}

	public void setLinvstock(List<Inventaire_stock> linvstock) {
		this.linvstock = linvstock;
	}

}
