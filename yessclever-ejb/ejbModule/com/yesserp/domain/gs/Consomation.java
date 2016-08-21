package com.yesserp.domain.gs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: consomation
 * 
 */
@Entity
@Table(name = "gs_consomation")
public class Consomation implements Serializable {

	private int id;
	private Date date;
	private double qte;

	private List<Consomation_lot> lc;

	private static final long serialVersionUID = 1L;

	public Consomation() {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

	@OneToMany(mappedBy = "consomation",cascade = CascadeType.ALL)
	public List<Consomation_lot> getLc() {
		return lc;
	}

	public void setLc(List<Consomation_lot> lc) {
		this.lc = lc;
	}
}
