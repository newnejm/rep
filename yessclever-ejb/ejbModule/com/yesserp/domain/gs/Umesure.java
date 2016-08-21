package com.yesserp.domain.gs;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Umesure
 * 
 */
@Entity
@Table(name = "gc_umes")
public class Umesure implements Serializable {

	private int id;
	private String nom;
	private String description;
	private List<Prod> lproduit;
	private static final long serialVersionUID = 1L;

	public Umesure() {
		super();
	}

	public Umesure(String nom, String desc) {
		this.nom = nom;
		this.description = desc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "umes")
	public List<Prod> getLproduit() {
		return lproduit;
	}

	public void setLproduit(List<Prod> lproduit) {
		this.lproduit = lproduit;
	}

}
