package com.yesserp.domain.gs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yesserp.domain.gs.STOK;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Inventaire
 * 
 */
@Entity
@Table(name = "gs_inventaire")
public class Inventaire implements Serializable {

	private int id;
	private Date date;
	private String rapport;

	private STOK stok;
	private List<Inventaire_stock> linvstock = new ArrayList<Inventaire_stock>();

	private static final long serialVersionUID = 1L;

	public Inventaire() {
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

	@ManyToOne
	public STOK getStok() {
		return stok;
	}

	public void setStok(STOK stok) {
		this.stok = stok;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRapport() {
		return rapport;
	}

	public void setRapport(String rapport) {
		this.rapport = rapport;
	}

	@OneToMany(mappedBy = "inventaire", cascade = CascadeType.ALL)
	public List<Inventaire_stock> getLinvstock() {
		return linvstock;
	}

	public void setLinvstock(List<Inventaire_stock> linvstock) {
		this.linvstock = linvstock;
	}
}
