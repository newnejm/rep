package com.yesserp.domain.gs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.yesserp.type.gs.TypeEval;

/**
 * Entity implementation class for Entity: STOK
 * 
 */
@Entity
@Table(name = "gs_stok")
public class STOK implements Serializable {

	private int id;
	private List<Stock> lstock = new ArrayList<Stock>();

	private static final long serialVersionUID = 1L;

	private Date date_inv;
	private int periode_inv;
	private TypeEval evaluation;
	private double valeur;

	private List<Inventaire> linv = new ArrayList<Inventaire>();

	public STOK() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "stok", cascade = CascadeType.ALL)
	public List<Stock> getLstock() {
		return lstock;
	}

	public void setLstock(List<Stock> lstock) {
		this.lstock = lstock;
	}

	public Date getDate_inv() {
		return date_inv;
	}

	public void setDate_inv(Date date_inv) {
		this.date_inv = date_inv;
	}

	public int getPeriode_inv() {
		return periode_inv;
	}

	public void setPeriode_inv(int periode_inv) {
		this.periode_inv = periode_inv;
	}

	public TypeEval getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(TypeEval evaluation) {
		this.evaluation = evaluation;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	@OneToMany(mappedBy = "stok")
	public List<Inventaire> getLinv() {
		return linv;
	}

	public void setLinv(List<Inventaire> linv) {
		this.linv = linv;
	}
}
